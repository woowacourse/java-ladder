package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("사용자의 이름은 1~5자 사이여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"산", "산초와아톰"})
    void checkNameLengthSuccess(String name) {
        Player player = new Player(name);

        assertThat(player.getName()).isEqualTo(name);
    }

    @DisplayName("1~5자 사이가 아닌 이름은 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "산초와아톰과"})
    void checkNameLengthFail(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1~5자 사이여야 합니다.");
    }
}
