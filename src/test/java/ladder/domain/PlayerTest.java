package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @DisplayName("이름과 위치를 입력하여 Player를 생성한다.")
    @Test
    void playerConstructTest() {
        assertThatCode(() -> new Player("명오", 0))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름이 1~5글자 범위를 벗어나면 예외를 발생한다.")
    @ValueSource(strings = {"", "우아한테크코스"})
    @ParameterizedTest
    void nameLengthTest(String name) {
        assertThatThrownBy(() -> new Player(name, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5글자 사이로 입력해주세요: %s".formatted(name));
    }

    @DisplayName("같은 위치를 가지면 true를 반환한다.")
    @Test
    void hasSameLocationTest() {
        Player player0 = new Player("명오", 0);
        Player player1 = new Player("제우스", 1);

        assertAll(
                () -> assertThat(player0.hasSameLocation(0)).isTrue(),
                () -> assertThat(player1.hasSameLocation(0)).isFalse()
        );
    }
}
