package domain;

import exception.InvalidLadderHeightException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class HeightTest {

    @DisplayName("입력 값이 조건에 맞는 경우 높이를 생성한다")
    @Test
    void createSuccess() {
        Height height = new Height("5");
        Assertions.assertThat(height.getHeight()).isEqualTo(5);
    }

    @DisplayName("높이가 숫자가 아닌 경우 오류를 던진다.")
    @Test
    void heightNotDigit() {
        Assertions.assertThatThrownBy(() -> new Height("a"))
                  .isExactlyInstanceOf(InvalidLadderHeightException.class);
    }

    @DisplayName("높이가 null 혹은 빈값으로 이루어져 있을 경우 오류를 던진다.")
    @ParameterizedTest
    @NullAndEmptySource
    void heightNullOrEmpty(String input) {
        Assertions.assertThatThrownBy(() -> new Height(input))
                  .isExactlyInstanceOf(InvalidLadderHeightException.class);
    }

    @DisplayName("높이가 공백으로만 이루어져 있을 경우 오류를 던진다.")
    @Test
    void heightNullOrEmpty() {
        Assertions.assertThatThrownBy(() -> new Height("    "))
                  .isExactlyInstanceOf(InvalidLadderHeightException.class);
    }
}
