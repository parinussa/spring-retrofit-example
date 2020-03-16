package com.example.springretrofit.controller;

import com.example.springretrofit.service.somewhere.SomewhereData;
import com.example.springretrofit.service.somewhere.SomewhereResponse;
import com.example.springretrofit.service.somewhere.SomewhereService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@RestController
@RequestMapping("api/somewhere")
public class SomewhereController {

    @Autowired
    private SomewhereService somewhereService;

    @PostMapping
    public SomewhereResponse create(@RequestBody SomewhereData data) throws Exception {
        return somewhereService.create(data);
    }

}
