package com.woowacourse.laddergame.domain.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerNamesVoTest {
    @Test
    void Player_정상이름입력() {
        String input = "pobi,crong,honux";
        PlayerNamesVo playerNamesVo = new PlayerNamesVo(input);
        for (String name : input.split(",")) {
            assertThat(playerNamesVo.contains(name)).isTrue();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiiii,crong,honux", "po bi,crong", "  ", ",pobi", "pobi,", "pobi, jay"})
    void Player_비정상이름입력(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerNamesVo(input);
        }).withMessage("Player 이름들이 잘못되었습니다");
    }

    @Test
    void Player_null입력() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new PlayerNamesVo(null);
        }).withMessage("Null 은 입력할 수 없습니다");
    }
}