package com.wisely.highlight_spring4.practice.ch1.di;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {
    public String sayhello(String word){
        return "Hello " + word + " !";
    }
}
