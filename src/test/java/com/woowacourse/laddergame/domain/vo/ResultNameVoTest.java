package com.woowacourse.laddergame.domain.vo;

import com.woowacourse.laddergame.domain.vo.ResultNameVo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ResultNameVoTest {
    @Test
    void 이름_정상_입력() {
        assertThatCode(() -> new ResultNameVo("pobi")).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi ", " pobi", "po bi", "1", "pobi,"})
    void 이름_비정상_입력(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultNameVo(input);
        }).withMessage("Result Name 이 잘못되었습니다");
    }

    @Test
    void 이름_null_입력() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new ResultNameVo(null);
        }).withMessage("Null 은 입력할 수 없습니다");
    }
}