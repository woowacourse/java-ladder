package com.woowacourse.ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {
    @Test
    void 아무입력이_없을때() {
        assertThat(InputValidator.isValidInput(Arrays.asList(""))).isFalse();
    }

    @Test
    void 공백만입력했을때() {
        assertThat(InputValidator.isValidInput(Arrays.asList("  "))).isFalse();
    }

    @Test
    void 길이가5_이상일때() {
        assertThat(InputValidator.isValidInput(Arrays.asList("abcde"))).isFalse();
    }
}
