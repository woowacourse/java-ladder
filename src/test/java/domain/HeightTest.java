package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Height;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @DisplayName("높이가 양수가 아닌 경우 예외 확인")
    @ValueSource(ints = {-100, -5, -1, 0})
    void errorNegativeNumber(int height) {
        Assertions.assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 높이는 양수만 가능합니다.");
    }


    @Test
    @DisplayName("높이가 양수 인 경우 정상적인 객체 생성 확인")
    void nonErrorPositiveNumber() {
        int height = 1;
        assertDoesNotThrow(() -> new Height(height));
    }
}
