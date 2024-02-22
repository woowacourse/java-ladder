package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderHeightTest {

    @DisplayName("int 값을 받아 LadderHeight 객체를 생성한다.")
    @Test
    void createLadderHeight() {
        int height = 3;
        assertThatCode(() -> new LadderHeight(height))
                .doesNotThrowAnyException();
    }

    // VO의 동일성을 보장하기 위해 equals 메서드를 재정의하였는데 TDD 관점에서 테스트가 필요하여 작성함.
    @DisplayName("높이 값이 같은 두 객체는 동일성이 보장된다.")
    @Test
    void equalsLadderHeight() {
        int height = 3;
        LadderHeight first = new LadderHeight(height);
        LadderHeight second = new LadderHeight(height);
        assertThat(first).isEqualTo(second);
    }

    @DisplayName("사다리 높이가 0 이하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 0})
    void validateLadderHeight(int given) {
        assertThatThrownBy(() -> new LadderHeight(given))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
