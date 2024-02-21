package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456", "hellooooo"})
    @DisplayName("이름이 요구하는 길이와 일치하지 않으면 에러를 발생한다.")
    void isValidNameLengthTest(String name) {

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 최대 5글자 까지 가능합니다.");
    }

    @Test
    @DisplayName("이름이 공백일 경우 에러를 발생한다.")
    void isNotBlankNameTest() {

        assertThatThrownBy(() -> new Name(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백을 허용하지 않습니다.");

    }

    @ParameterizedTest
    @ValueSource(strings = {"#skdn", "p@bi"})
    @DisplayName("이름에 특수문자가 포함되면 에러를 발생시킨다.")
    void hasNotContainsSpecialCharacters(String name) {

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 특수문자를 포함할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"bri", "polla", "jazz", "hogi", "aru"})
    @DisplayName("Name 정상 생성")
    void createName(String name) {

        assertDoesNotThrow(() -> new Name(name));
    }

}
