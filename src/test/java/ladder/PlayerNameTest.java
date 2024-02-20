package ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PlayerNameTest {

    @DisplayName("이름은 5글자를 넘을 수 없다")
    @ParameterizedTest
    @CsvSource({"steve!", "123 45", "123456"})
    void validateTest(String name) {

        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 넘을 수 없습니다");
    }
}
