package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("참여자 이름의")
public class PlayerNameTest {

    private static final String NAME_SIZE_ERROR_MESSAGE = "이름은 1 ~ 5 글자여야 합니다.";
    private static final String VALUE_ERROR_MESSAGE = "이름은 영어나 숫자로만 가능합니다.";

    @DisplayName("길이가 범위 밖인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void createNameFail(String input) {
        assertThatThrownBy(() -> new PlayerName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NAME_SIZE_ERROR_MESSAGE);
    }

    @DisplayName("길이가 범위 내인 경우 정상 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void createNameSuccess(String input) {
        Assertions.assertDoesNotThrow(() -> new PlayerName(input));
    }

    @DisplayName("문자나 숫자 이외의 값이 포함되면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {" ", " pobi", "dk$2"})
    void createNameNotWordFail(String input) {
        assertThatThrownBy(() -> new PlayerName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(VALUE_ERROR_MESSAGE);
    }

}
