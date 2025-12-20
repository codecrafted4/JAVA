package com.example.calculatorService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    @Test
    void whenInputsArePositiveReturnPositive(){
        int  a = 10;
        int b = 5;
        int expected = 15;
        int actual = calculator.add(a,b);
        Assertions.assertEquals(expected,actual);

    }
    @Test
    void whenBIsGreaterThanA(){
        int a = 10;
        int b = 15;
        int expected = -5;
        int actual = calculator.sub(a,b);
        Assertions.assertEquals(expected,actual);
    }
}
