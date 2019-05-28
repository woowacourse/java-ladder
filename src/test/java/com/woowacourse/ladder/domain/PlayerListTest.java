package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerListTest {
    @Test
    void 참가자이름으로_공백_입력했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new PlayerList(Arrays.asList(" "));
        });
    }

    @Test
    void 참가자이름으로_아무것도_입력안했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new PlayerList(Arrays.asList(""));
        });
    }

    @Test
    void 참가자이름으로_all을_입력했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new PlayerList(Arrays.asList("all"));
        });
    }

    @Test
    void 참가자이름으로_공백과쉼표를섞어서_입력했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new PlayerList(Arrays.asList("abc,,,  ,as"));
        });
    }
}
