package com.woowacourse.stringcalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringProcessorTest {

    @Test
    void testSplitDefaultDelimiter() {
        List<Integer> nums = StringProcessor.split("1,2,3");
        assertThat(nums).isEqualTo(Arrays.asList(1, 2, 3));
        nums = StringProcessor.split("1,2:3");
        assertThat(nums).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 숫자가아닌입력_예외테스트 () {
        assertThrows(IllegalArgumentException.class,() ->{
            StringProcessor.split("a,b,c");
        });
    }

    @Test
    void 빈문자열_또는_null입력했을때_테스트 () {
        assertThat(StringProcessor.split("")).isEqualTo(Collections.singletonList(0));
        assertThat(StringProcessor.split(null)).isEqualTo(Collections.singletonList(0));
    }

    @Test
    void 커스텀_구분자가_있는_경우() {
        String input = "//!\n2,4,6";
        assertThat(StringProcessor.split(input)).isEqualTo(Arrays.asList(2, 4, 6));
    }

    @Test
    void testSplit() {
        String str = "//!";
        assertThat(str.split("//")[1]).isEqualTo("!");
    }

    @Test
    void 유효하지않은_커스텀구분자_지시자_예외테스트() {
        assertThrows(IllegalArgumentException.class,() ->{
            StringProcessor.split("/!\n1,2,3");
        });
    }

    @Test
    void 커스텀구분자안에_숫자가있을때_예외테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.split("//1234\n1,2,3");
        });
    }

    @Test
    void 숫자가아닌문자로_시작하는_경우_예외테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.split("//:\n,1,2,3");
        });
    }

    @Test
    void 유효하지않은_구분자를_사용하는경우_예외테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.split("1!2!3");
        });
    }

    @Test
    void 쉼표를_연속으로_사용하는경우_예외테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringProcessor.split("1,,2,,,3");
        });
    }

    @Test
    void 커스텀구분자안에_숫자와문자가_같이_있을때_예외테스트() {
        assertThat(StringProcessor.split("//ab34\n1ab342")).isEqualTo(Arrays.asList(1,2));
    }


}
