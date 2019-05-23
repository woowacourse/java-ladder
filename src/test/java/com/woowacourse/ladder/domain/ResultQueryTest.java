package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultQueryTest {
    PlayerList playerList;

    @BeforeEach
    void setUp() {
        playerList = new PlayerList(Arrays.asList("pobi","crong"));
    }

    @Test
    void 결과보고싶은_사람을_공백으로_입력했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new ResultQuery("  ");
        });
    }

    @Test
    void 없는이름을_결과보고싶은_사람으로_입력했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new ResultQuery("honux");
        });
    }

    @Test
    void 아무것도_입력하지않을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new ResultQuery("");
        });
    }
}
