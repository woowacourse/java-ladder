package domain.player;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class NameTest {

    @DisplayName("객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest() {
        assertThatNoException()
                .isThrownBy(() -> new Name("takan"));
    }

    @DisplayName("이름이 빈 값일 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void constructFailWithBlankName(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5글자를 넘어가면 예외가 발생한다.")
    @Test
    void constructFailWithTooLongName() {
        assertThatThrownBy(() -> new Name("zangsu"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("앞, 뒤 공백을 포함한 이름을 사용하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" name", "name ", " na "})
    void constructFailWithNameNotStriped(String wrongName) {
        assertThatThrownBy(() -> new Name(wrongName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("대소문자를 구분하지 않고 all과 동일한 이름을 사용하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"all", "All", "ALL"})
    void constructFailWithNameIsAll(String wrongName) {
        assertThatThrownBy(() -> new Name(wrongName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
