package domain.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositionTest {
    @ParameterizedTest(name = "{0}을 가진 위치가 생성된다")
    @ValueSource(strings = {"1", "5"})
    void makePlayerTest(int provided) {
        assertThatNoException().isThrownBy(() -> new Position(provided));
    }
}
