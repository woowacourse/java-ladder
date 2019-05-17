package com.woowacourse.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultItemsTest {
    PlayerList playerList;

    @BeforeEach
    void setUp() {
        playerList = new PlayerList(Arrays.asList("pobi","crong"));
    }

    @Test
    void 실행결과들을_공백으로_입력했을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new ResultItems(Arrays.asList("   ","    "),playerList);
        });
    }

    @Test
    void 실행결과수와_이름들의수가_일치하지않을때_예외() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new ResultItems(Arrays.asList("pobi","crong","honux"),playerList);
        });
    }
}
