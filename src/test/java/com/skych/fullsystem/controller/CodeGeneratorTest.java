package com.skych.fullsystem.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mybatis.generator.internal.util.JavaBeansUtil;

import com.skych.fullsystem.util.CollectionUtil;

public class CodeGeneratorTest {

    @Test
    public void testCase() {
        List<String> list = Collections.emptyList();
        Map map = Collections.EMPTY_MAP;
        System.out.println(CollectionUtil.isEmpty(map));
    }
}
