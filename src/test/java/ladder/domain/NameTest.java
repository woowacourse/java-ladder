package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @Test
    @DisplayName("알맞은 길이의 이름을 넣으면 name을 생성한다")
    void shouldBetween1and5WhenNameCreate() {
        // given
        // when
        // then
        assertDoesNotThrow(() -> new Name("abcde"));
    }

    @Test
    @DisplayName("너무 긴 길이의 이름을 넣으면 예외를 발생한다")
    void shouldThrowExceptionWhenWrongLength() {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Name("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상 5자 이하여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("공백을 넣으면 예외를 발생한다")
    @NullSource
    void shouldThrowExceptionWhenBlank(String input) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("입력받은 값과 같은 값을 가지면 true를 반환한다.")
    void shouldTrueWhenInputSameValue() {
        String nameValue = "name";
        Name name = new Name("name");
        assertThat(name.haveSameValueWith(nameValue)).isTrue();
    }

    @Test
    @DisplayName("입력받은 값과 같은 값을 가지지 않으면 false를 반환한다..")
    void shouldFalseWhenInputDifferentValue() {
        String differentNameValue = "abcd";
        Name name = new Name("name");
        assertThat(name.haveSameValueWith(differentNameValue)).isFalse();
    }
}
