package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class HeightTest {
    @Test
    void 사다리높이로_영어를_입력했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height("ab");
        });
    }

    @Test
    void 사다리높이로_공백_입력했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height("  ");
        });
    }

    @Test
    void 사다리높이로_아무것도_입력안했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height("");
        });
    }

    @Test
    void 사다리높이로_1이하의수를_입력했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height("-1");
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height("1");
        });
    }
}
