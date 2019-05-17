package com.woowacourse.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {
    @Test
    void 아무입력이_없을때() {
        Assertions.assertThat(InputValidator.isValidNamesInput(Arrays.asList(""))).isFalse();
    }

    @Test
    void 공백만입력했을때() {
        assertThat(InputValidator.isValidNamesInput(Arrays.asList("  "))).isFalse();
    }

    @Test
    void 이름의길이가5_이상일때() {
        assertThat(InputValidator.isValidNamesInput(Arrays.asList("abcdae"))).isFalse();
    }

    @Test
    void 이름으로all을입력했을때() {
        assertThat(InputValidator.isValidNamesInput(Arrays.asList("all"))).isFalse();
    }

    @Test
    void 실행결과로_all을_입력했을때() {
        assertThat(InputValidator.isValidDestinationsInput(Arrays.asList("all"))).isTrue();
    }

    @Test
    void 실행결과로_공백을_입력했을때() {
        assertThat(InputValidator.isValidDestinationsInput(Arrays.asList("   "))).isFalse();
    }

    @Test
    void 실행결과로_아무입력이없을떄() {
        assertThat(InputValidator.isValidDestinationsInput(Arrays.asList(""))).isFalse();
    }

}
