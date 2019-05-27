package com.woowacourse.laddergame.domain.vo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderResultsVoTest {
    @Test
    void 사다리_결과_null_입력() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LadderResultsVo(null);
        }).withMessage("Null 은 입력할 수 없습니다");
    }
}