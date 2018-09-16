package com.skych.fullsystem.util;

import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testUnderLine2CamelCase() {
        String test1 = "abc_abc_abc_";
        String test2 = "_abc_abc_abc_";
        String test3 = "ABC_ABC_ABC";
        String test4 = "aBc_aBC_BBc";
        System.out.println(StringUtil.underLine2CamelCase(test1));
        System.out.println(StringUtil.underLine2CamelCase(test2));
        System.out.println(StringUtil.underLine2CamelCase(test3));
        System.out.println(StringUtil.underLine2CamelCase(test4));
        System.out.println(StringUtil.underLine2CamelCase("AbcAbcAbc"));
    }
}
