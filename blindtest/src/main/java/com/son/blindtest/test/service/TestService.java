package com.son.blindtest.test.service;

import com.son.blindtest.test.model.TestEntity;
import com.son.blindtest.test.model.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;


}
