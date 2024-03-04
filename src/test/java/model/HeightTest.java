package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class HeightTest {
    @DisplayName("입력된 사다리 높이가 0 이하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-5", "-1", "0"})
    void validateLadderHeight(String heightOutOfRange) {
        assertThatThrownBy(() -> new Height(heightOutOfRange))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리 높이는 1 이상의 정수이어야 한다.");
    }

    @DisplayName("입력된 사다리 높이가 숫자 형식이 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"r", "ㄱ", "*"})
    void validateLadderHeightFormat(String heightOutOfFormat) {
        assertThatThrownBy(() -> new Height(heightOutOfFormat))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값은 숫자형식이어야 한다.");
    }

    @DisplayName("입력된 사다리 높이가 숫자 형식이 아니라면 예외가 발생한다.")
    @Test
    void isDesignatedHeight() {
        Height height = new Height("3");

        assertThat(height.isDesignatedHeight(2)).isFalse();
        assertThat(height.isDesignatedHeight(3)).isTrue();
    }
}
