package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayerNameTest {
    @DisplayName("플레이어 이름의 길이가 1~5일때 생성")
    @ValueSource(strings = {"a", "abcde"})
    @ParameterizedTest
    void createPlayerName(String playerName) {
        assertThatNoException()
                .isThrownBy(() -> new PlayerName(playerName));
    }

    @DisplayName("빈문자열 입력 시 예외")
    @Test
    void isBlank() {
        assertThatThrownBy(() -> {
            new PlayerName("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 이름이 5글자 초과 시 예외")
    @Test
    void playerNameSizeOver() {
        assertThatThrownBy(() -> {
            new PlayerName("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
