package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("정상적인 이름은 예외를 발생하지 않는다")
    void normal_name_doesnt_throw_exception() {
        String nameA = "A";
        Name name = new Name(nameA);

        assertThat(name).isEqualTo(new Name(nameA));
    }

    @Test
    @DisplayName("이름의 길이가 1 보다 작다면 예외가 발생한다")
    void name_length_less_than_one_throw_exception() {
        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 1 ~ 5 자 이어야 합니다.");
    }

    @Test
    @DisplayName("이름의 길이가 5 보다 크다면 예외가 발생한다")
    void name_length_more_than_five_throw_exception() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 1 ~ 5 자 이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"망크", "+"})
    @DisplayName("이름이 영어와 숫자가 아니라면 예외가 발생한다")
    void name_not_alphanumeric_throw_exception(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 영어와 숫자가 아니라면 예외가 발생한다");
    }


}
