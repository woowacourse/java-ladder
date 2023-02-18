package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @DisplayName("앞 뒤 공백을 제외한 이름의 길이가 1글자부터 5글자 사이인 경우 플레이어가 올바르게 생성된다.")
    @ParameterizedTest
    @CsvSource(value = {"  kong:4", "kong  :4", "ko ng:5"}, delimiter = ':')
    void validateTest(String name, int length) {
        Player player = new Player(name);
        assertThat(player.getName().length()).isEqualTo(length);
    }

    @DisplayName("사람 이름은 1글자에서 5글자 사이이다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "kongha", "  ", "ko   ng"})
    void validateTest2(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람 이름은 1글자에서 5글자 사이이어야 합니다.");
    }

    @DisplayName("사람 이름이 1글자부터 5글자 사이로 입력되는 경우에는 플레이어가 생성된다.")
    @ParameterizedTest
    @ValueSource(strings = {"odo", "kong"})
    void validateTest3(String name) {
        assertThatCode(() -> new Player(name))
                .doesNotThrowAnyException();
    }
}
