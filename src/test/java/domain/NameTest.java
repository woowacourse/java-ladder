package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("이름은 ")
class NameTest {

    @Test
    @DisplayName("정상적인 이름이 입력 시 이름 객체 생성")
    void whenCorrectNameThenSuccess() {
        assertThatCode(() -> new Name("crong"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("5글자 초과의 이름 입력시 익셉션 발생")
    void whenNameOverFive() {
        assertThatThrownBy(() -> new Name("blackcat"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("5글자 이하를 입력해주세요.");
    }

    @Test
    @DisplayName("빈 문자가 들어왔을 경우 익셉션 발생")
    void whenBlack(){
        assertThatThrownBy(()->new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("한글자 이상 입력해주세요.");
    }

}