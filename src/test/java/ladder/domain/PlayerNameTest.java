package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNameTest {

    @DisplayName("이름은 5글자를 넘을 수 없다")
    @ParameterizedTest
    @CsvSource({"steve!", "123 45", "123456"})
    void validateTest_WhenLengthIsOver5(String name) {

        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 넘을 수 없습니다.");
    }

    @DisplayName("이름에 공백 또는 Null 이 오면 안된다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = " ")
    void validateTest_WhenNameIsEmpty(String name) {

        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 한글자 이상이어야 합니다.");
    }

    @DisplayName("이름이 1글자 이상 5글자 이하인 경우, 객체가 정상적으로 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"steve", "lucy", "bri"})
    void validateTest_WhenNameSizeIsInRange(String name) {
        PlayerName playerName = new PlayerName(name);

        assertThat(playerName.getName()).isEqualTo(name);
    }
}
