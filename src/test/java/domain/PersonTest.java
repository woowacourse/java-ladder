package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {

    @Test
    @DisplayName("Person 생성 확인")
    void person(){
        new Person("무민");
    }

    @Test
    @DisplayName("이름에 6글자 이상 입력시 예외 발생")
    void validateNameLength(){
        assertThatThrownBy(() -> new Person("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {""," ","   "})
    @DisplayName("이름에 공백 입력시 예외 발생")
    void validateBlankName(String blankName){
        assertThatThrownBy(() -> new Person(blankName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
