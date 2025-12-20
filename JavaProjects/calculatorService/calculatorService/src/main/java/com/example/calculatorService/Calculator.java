package com.example.calculatorService;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int add(int a,int b){
        return a+b;
    }
    public int mult(int a,int b){
        return a*b;
    }
    public int sub(int a,int b){
        return a-b;
    }
    public int devide (int a,int b){
        return a/b;
    }


}
