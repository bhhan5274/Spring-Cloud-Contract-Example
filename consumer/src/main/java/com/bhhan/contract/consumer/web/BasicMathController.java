package com.bhhan.contract.consumer.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hbh5274@gmail.com on 2020-11-17
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequiredArgsConstructor
public class BasicMathController {
    private final RestTemplate restTemplate;

    @GetMapping(value = "/calculate")
    public String checkOddAndEven(@RequestParam("number") Integer number){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        ResponseEntity<String> responseEntity = restTemplate.exchange(String.format("http://localhost:8090/validate/prime-number?number=%d", number), HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class);

        return responseEntity.getBody();
    }
}
