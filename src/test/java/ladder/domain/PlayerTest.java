package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @DisplayName("입력된 인자를 name으로 가진다.")
    @Test
    void playerConstructTest() {
        Player player = new Player("명오");

        assertAll(
                () -> assertThat(player.name()).isEqualTo("명오")
        );
    }

    @DisplayName("이름이 1~5글자 범위를 벗어나면 예외를 발생한다.")
    @ValueSource(strings = {"", "우아한테크코스"})
    @ParameterizedTest
    void nameLengthTest(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5글자 사이로 입력해주세요: %s".formatted(name));
    }

    @DisplayName("이름이 명령어면 예외를 발생한다.")
    @ValueSource(strings = {"all", "quit"})
    @ParameterizedTest
    void invalidNameTest(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("명령어를 이름으로 가질 수 없습니다: %s".formatted(name));
    }
}
