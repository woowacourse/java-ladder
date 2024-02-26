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
}
