package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.prize.Prize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrizeTest {
    @Test
    void 결과명이_다섯글자를_넘으면_예외가_발생한다() {
        String prizeName = "600000";

        assertThatThrownBy(() -> new Prize(prizeName)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 결과명이_빈값_혹은_공백이면_예외가_발생한다(String prizeName) {
        assertThatThrownBy(() -> new Prize(prizeName)).isInstanceOf(IllegalArgumentException.class);
    }
}
