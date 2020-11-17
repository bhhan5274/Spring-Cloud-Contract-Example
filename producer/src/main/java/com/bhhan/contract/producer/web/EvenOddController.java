package com.bhhan.contract.producer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hbh5274@gmail.com on 2020-11-16
 * Github : http://github.com/bhhan5274
 */

@RestController
public class EvenOddController {
    @GetMapping(value = "/validate/prime-number")
    public String inNumberPrime(@RequestParam("number") Integer number){
        return number % 2 == 0 ? "Even" : "Odd";
    }
}
