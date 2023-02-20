package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @Test
    @DisplayName("이름에 6글자 이상 입력시 예외 발생")
    void validateNameLength(){
        assertThatThrownBy(() -> new Player("123456", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이름 길이는 5자를 넘길 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ","   "})
    @DisplayName("이름에 공백 입력시 예외 발생")
    void validateBlankName(String blankName){
        assertThatThrownBy(() -> new Player(blankName, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 빈 문자열 입니다.");
    }
}
