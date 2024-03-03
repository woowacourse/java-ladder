package domain;

import domain.player.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static domain.ResultViewPlayer.EXISTING_PLAYER_OR_COMMEND_MESSAGE;

class ResultViewPlayerTest {

    @DisplayName("결과를 볼 사용자는 all 또는 기존 사용자들의 이름만 허용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"산초", "아톰", "all"})
    void create(String name) {
        List<String> names = List.of("산초", "아톰");
        Players players = new Players(names);

        Assertions.assertThatCode(() -> new ResultViewPlayer(name, players))
                .doesNotThrowAnyException();
    }

    @DisplayName("결과를 볼 사용자는 all 또는 기존 사용자들의 이름이 아니면 예외를 발생시킨다.")
    @Test
    void allowAllOrPlayerName() {
        String name = "산초";
        List<String> names = List.of("수달", "아톰");
        Players players = new Players(names);

        Assertions.assertThatThrownBy(() -> new ResultViewPlayer(name, players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(EXISTING_PLAYER_OR_COMMEND_MESSAGE);
    }
}
