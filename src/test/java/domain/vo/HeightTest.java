package domain.vo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest(name = "적절한 크기의 높이일 경우를 테스트")
    @ValueSource(strings = {"1", "5000"})
    public void testInvalidHeight(int provided) {
        assertThatNoException().isThrownBy(() -> new Height(provided));
    }

    @ParameterizedTest(name = "적절하지 않은 크기의 높이일 경우를 테스트")
    @ValueSource(strings = {"0", "5001"})
    public void testvalidHeight(int provided) {
        assertThatThrownBy(() -> new Height(provided)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동등성 비교 테스트")
    public void testEquals() {
        //given
        int value = 10;
        Height target = new Height(value);

        //when
        boolean result = target.equals(new Height(10));

        //then
        Assertions.assertThat(result).isTrue();
    }
}
