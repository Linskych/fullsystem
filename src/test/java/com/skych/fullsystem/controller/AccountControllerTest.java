package com.skych.fullsystem.controller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(Parameterized.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"classpath:spring-application.xml"})
public class AccountControllerTest {

    private int a,b,sum;
    
    public AccountControllerTest(int a, int b, int sum) {
        this.a = a;
        this.b = b;
        this.sum = sum;
    }
    
    @Parameters(name="{index}: add({0}+{1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {1,2,3},{2,3,5},{3,4,7},{4,5,9}
        });
    }
    
    @Test
    public void testAdd() {
//        assertEquals(sum, AccountController.add(a, b));
    }
}
