package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("참여자 이름의")
public class NameTest {

    private static final String LENGTH_ERROR_MESSAGE = "이름은 1 ~ 5 글자여야 합니다.";

    @DisplayName("길이가 범위 밖인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void createNameFail(String input) {
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LENGTH_ERROR_MESSAGE);
    }

    @DisplayName("길이가 범위 내인 경우 정상 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void createNameSuccess(String input) {
        Assertions.assertDoesNotThrow(() -> new Name(input));
    }

}
