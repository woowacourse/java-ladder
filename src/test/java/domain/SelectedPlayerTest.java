package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class SelectedPlayerTest {

    @DisplayName("결과를 볼 사용자는 all 또는 기존 사용자들의 이름만 허용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"산초", "all"})
    void create(String name) {
        List<String> names = List.of("산초", "아톰");

        Assertions.assertThatCode(() -> new SelectedPlayer(name, names))
                .doesNotThrowAnyException();
    }

    @DisplayName("결과를 볼 사용자는 all 또는 기존 사용자들의 이름이 아니면 예외를 발생시킨다.")
    @Test
    void allowAllOrPlayerName() {
        String name = "산초";
        List<String> names = List.of("수달", "아톰");

        Assertions.assertThatThrownBy(() -> new SelectedPlayer(name, names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("all이나 기존 사용자 이름을 입력해야 합니다.");
    }
}
