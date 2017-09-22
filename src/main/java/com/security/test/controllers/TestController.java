package com.security.test.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asandoval on 22/09/2017.
 */

@RestController
@RequestMapping(value = "/controller")
public class TestController {

    @RequestMapping(value = "public", method = RequestMethod.GET)
    public String publicHello() {
        return "Hello from public method";
    }

    @PreAuthorize("isAuthorized('/controller/private')")
    @RequestMapping(value = "private", method = RequestMethod.GET)
    public String privateHello() {
        return "Hello from private method";
    }
}
