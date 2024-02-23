package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @DisplayName("높이 객체가 정상적으로 생성된다.")
    @Test
    void constructSuccessTest() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Height(5)); // TODO 경계값을 넣어주는게 더 좋을 듯
    }

    @DisplayName("높이가 자연수가 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-10, 0})
    void constructFailTest(int intValue) {
        Assertions.assertThatThrownBy(() -> new Height(intValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
