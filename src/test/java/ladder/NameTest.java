package ladder;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @ParameterizedTest
    @ValueSource(strings = {"abcedf", "", " "})
    @DisplayName("잘못된 길이의 이름을 넣으면 예외를 발생한다")
    void shouldThrowExceptionWhenWrongLength(String input) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상 5자 이하여야 합니다.");
    }
}
