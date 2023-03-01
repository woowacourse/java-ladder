package laddergame.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RewardTest {

    @Test
    @DisplayName("올바른 값이 들어오면 오류가 발생하지 않는다.")
    void Should_Success_When_ResultInput() {
        assertDoesNotThrow(() -> new Reward("꽝"));
    }

    @Test
    @DisplayName("앞 뒤의 공백은 제거된다")
    void Should_Trim_When_FrontAndBackBlank() {
        String name = " name ";
        assertThat(new Reward(name).getName()).isEqualTo(new Reward(name.trim()).getName());
    }

    @Test
    @DisplayName("앞 뒤의 공백은 제거된다")
    void Should_Trim_When_MiddleOfBlank() {
        String name = "na me";
        String expect = "name";
        assertThat(new Reward(name).getName()).isEqualTo(expect);
    }

    @ParameterizedTest(name = "{displayName} {index} ==> name : ''{0}''")
    @ValueSource(strings = {"꽝꽝꽝꽝꽝꽝", "  ", " 123 4 56 ", "126 789"})
    @DisplayName("공백이 제거된 후 문자열의 길이가 1보다 작고 5보다 클 때 예외 발생")
    void Should_ThrowException_When_OutOfRange(String name) {
        assertThatThrownBy(() -> new Reward(name))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("공백이 제거된 결과의 길이는");
    }

}
