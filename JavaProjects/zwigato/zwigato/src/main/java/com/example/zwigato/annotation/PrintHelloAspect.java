package com.example.zwigato.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintHelloAspect {
    @Before("@annotation(PrintHello)")
    public void printHello(){
        System.out.println("Hello World");
    }

}
