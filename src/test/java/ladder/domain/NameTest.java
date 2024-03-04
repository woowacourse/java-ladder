package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.domain.player.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @DisplayName("입력된 인자를 value로 가진다.")
    @Test
    void playerConstructTest() {
        Name player = new Name("명오");

        assertThat(player.value()).isEqualTo("명오");
    }

    @DisplayName("이름이 1~5글자 범위를 벗어나면 예외를 발생한다.")
    @ValueSource(strings = {"", "우아한테크코스"})
    @ParameterizedTest
    void nameLengthTest(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5글자 사이로 입력해주세요: %s".formatted(name));
    }

    @DisplayName("이름이 명령어면 예외를 발생한다.")
    @ValueSource(strings = {"all", "quit"})
    @ParameterizedTest
    void invalidNameTest(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("명령어를 이름으로 가질 수 없습니다: %s".formatted(name));
    }
}
