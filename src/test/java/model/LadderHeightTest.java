package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderHeightTest {
    @ParameterizedTest(name = "LadderHeight가 {0} 일 경우 객체 생성 성공 테스트")
    @ValueSource(ints = {1, 3, 5})
    void createLadderHeightTest(int input) {
        Assertions.assertThatNoException().isThrownBy(() -> new LadderHeight(input));
    }

    @ParameterizedTest(name = "LadderHeight가 {0} 일 경우 실패 테스트")
    @ValueSource(ints = {0, -1})
    void validateLadderHeightTest(int input) {
        assertThatThrownBy(
                () -> {
                    new LadderHeight(input);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LadderHeight가 20초과할 경우 객체 생성 실패")
    void createLadderHeightMoreThanMax(){
        assertThatThrownBy(
                () -> {
                    new LadderHeight(21);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
