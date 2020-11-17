package com.bhhan.contract.consumer.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by hbh5274@gmail.com on 2020-11-17
 * Github : http://github.com/bhhan5274
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
    ids = "com.bhhan:producer:+:stubs:8090")
class BasicMathControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void given_WhenPassEvenNumberIsQueryParam_ThenReturnEven() throws Exception {
        mockMvc.perform(get("/calculate?number=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Even"));
    }

    @Test
    void given_WhenPassOddNumberIsQueryParam_ThenReturnOdd() throws Exception {
        mockMvc.perform(get("/calculate?number=1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Odd"));
    }
}