package domain.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WidthTest {

    @ParameterizedTest(name = "{0} 너비는 허용된다.")
    @ValueSource(strings = {"1", "99"})
    void makeWidthSuccess(int provided) {
        assertThatNoException().isThrownBy(() -> new Width(provided));
    }

    @ParameterizedTest(name = "{0} 너비는 허용되지 않는다.")
    @ValueSource(strings = {"0", "100"})
    void makeWidthFailure(int provided) {
        assertThatThrownBy(() -> new Width(provided)).isInstanceOf(IllegalArgumentException.class);
    }
}
