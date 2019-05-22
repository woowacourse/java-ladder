package com.woowacourse.laddergame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PlayerTest {
    @Test
    void 정상이름_초기화() {
        Player player = new Player("aiden");
        assertThat(player.getName()).isEqualTo("aiden");
    }

    @Test
    void 비정상이름_5자이상() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Player("aidenjay");
        }).withMessage("이름은 5글자 까지 가능합니다");
    }

    @Test
    void 공백_입력() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Player(" ");
        }).withMessage("이름에 공백이 있으면 안됩니다");
    }

    @Test
    void null_입력() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Player(null);
        }).withMessage("null을 입력할 수 없습니다");
    }

    @Test
    void 이름에_공백이_있는_경우() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Player("j ay");
        }).withMessage("이름에 공백이 있으면 안됩니다");
    }

    @Test
    void all_이라는_이름입력() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Player("all");
        }).withMessage("all은 player 이름으로 입력할 수 없습니다");
    }
}
