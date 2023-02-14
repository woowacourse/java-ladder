package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("참여자 수")
public class PlayerNumberTest {
    public static final String RANGE_ERROR_MESSAGE = "참여자 수는 2 ~ 20명만 가능합니다.";

    @DisplayName("범위 밖인 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 21})
    void createNameFail(int input) {
        assertThatThrownBy(() -> new PlayerNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RANGE_ERROR_MESSAGE);
    }

    @DisplayName("범위 내인 경우 정상 작동")
    @ParameterizedTest
    @ValueSource(ints = {2, 20})
    void createNameSuccess(int input) {
        Assertions.assertDoesNotThrow(() -> new PlayerNumber(input));
    }
    
    @DisplayName("따른 사다리 개수 생성 정상 작동")
    @ParameterizedTest
    @CsvSource(value = {"2:1", "3:2"}, delimiter = ':')
    void createLineNumberSuccess(int input, int expected) {
        PlayerNumber playerNumber = new PlayerNumber(input);
        assertThat(playerNumber.getLineNumber())
                .isEqualTo(expected);
    }

}
