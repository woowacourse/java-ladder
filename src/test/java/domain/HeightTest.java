package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @Test
    void constructSuccessTest() {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new Height(5));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 0})
    void constructFailTest(int intValue) {
        Assertions.assertThatThrownBy(() -> new Height(intValue))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
