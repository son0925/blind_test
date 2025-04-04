package com.son.blindtest.test.controller;

import com.son.blindtest.test.model.TestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/")
    public List<TestEntity> getTestList() {
        return null;
    }

}
