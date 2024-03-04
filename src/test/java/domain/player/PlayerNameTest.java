package domain.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerNameTest {
    @Test
    @DisplayName("문자열을 통해 이름을 생성한다.")
    void createName() {
        //Given
        String value = "도비";

        //When
        PlayerName playerName = new PlayerName(value);

        //Then
        assertEquals(playerName.getValue(), value);
    }

    @Test
    @DisplayName("다섯글자를 초과한 문자열을 통한 생성은 예외를 발생한다.")
    void throwExceptionWhenInputStringIsOverThan5() {
        String value = "longName";

        assertThrows(IllegalArgumentException.class, () -> new PlayerName(value));
    }

    @ParameterizedTest
    @DisplayName("눈에 보이지 않는 공백들로 이루어진 생성은 예외를 발생한다.")
    @ValueSource(strings = {"", " "})
    void throwExceptionWhenInputStringHasBlank(String value) {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName(value));
    }

    @ParameterizedTest
    @DisplayName("공백이 포함된 문자열을 이용한 생성은 예외를 발생한다.")
    @ValueSource(strings = {"d obby", "j o y", "도  비"})
    void throwExceptionWhenInputStringContainsBlank(String value) {
        assertThrows(IllegalArgumentException.class, () -> new PlayerName(value));
    }

}
