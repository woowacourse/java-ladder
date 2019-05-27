package com.woowacourse.laddergame.domain.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class HeightVoTest {
    @ParameterizedTest
    @ValueSource(strings = {"01", "ab", "!!", "-1", " ", "1_000"})
    void 높이_비정상값(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new HeightVo(input);
        }).withMessage("정상적인 사다리 높이가 아닙니다");
    }

    @Test
    void 높이_null() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new HeightVo(null);
        }).withMessage("Null 은 입력할 수 없습니다");
    }
}