package com.skych.fullsystem.mybatis.plugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.skych.fullsystem.util.StringUtil;

public class CamelHumpInterceptorTest {

    @Test
    public void testProcessMap() {
        Map<String, Object> map = new HashMap<>(110000,0.95f);
        String originKey = "abc_abc_dbc";
        for (int i = 0; i < 100000; i++) {
            map.put(originKey + i, originKey + i);
        }
//        CamelHumpInterceptor interceptor = new CamelHumpInterceptor();
//        interceptor.processMap(map);
    }
}
