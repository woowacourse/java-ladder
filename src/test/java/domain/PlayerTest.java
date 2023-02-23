package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayerTest {

    @Test
    @DisplayName("문자열로 된 이름 입력값이 6글자를 미만이면 player 객체가 생성")
    void makePlayerUsingLessThanSixCharactersAsAnInput() {
        String inputName = "abcde";
        assertDoesNotThrow(() -> new Player(inputName));

    }

    @Test
    @DisplayName("문자열로 된 이름 입력값이 5글자를 초과할 경우 입 예외 발생")
    void throwExceptionUsingMoreThanFiveCharactersAsAnInput() {
        String inputName = "abcdef";
        assertThatThrownBy(() -> new Player(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사람 이름은 최대 5글자 입니다.");
    }
}
