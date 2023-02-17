package domain.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class HeightTest {

    @ParameterizedTest(name = "{0} 높이는 허용된다.")
    @ValueSource(strings = {"1", "5000"})
    void makeHeightSuccess(int provided) {
        assertThatNoException().isThrownBy(() -> new Height(provided));
    }

    @ParameterizedTest(name = "{0} 높이는 허용되지 않는다.")
    @ValueSource(strings = {"0", "5001"})
    void makeHeightFailure(int provided) {
        assertThatThrownBy(() -> new Height(provided))
                .hasMessage("높이는 1~5000 사이의 숫자만 가능합니다.");
    }
}
