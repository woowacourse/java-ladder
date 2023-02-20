package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "aaaaa"})
    void Name의_길이가_1_이상_5_이하이면_예외가_발생하지_않는다(String name) {
        assertThatCode(() -> new Name(name)).doesNotThrowAnyException();
    }

    @Test
    void Name의_길이가_5를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Name("aaaaaa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최대 5글자까지만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "           "})
    void Name이_공백이면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 공백일 수 없습니다.");
    }

}
