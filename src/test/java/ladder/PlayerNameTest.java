package ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerNameTest {
    private static final String nullString = null;

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
    void validateTest_WhenNameIsEmpty(String name){
        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 한글자 이상이어야 합니다.");
    }

}
