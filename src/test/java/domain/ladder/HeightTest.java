package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("범위 안의 높이는 예외를 발생하지 않는가")
    void height_in_range_throws_exception(int height) {
        assertThatCode(() -> new Height(height))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    @DisplayName("범위를 벗어나는 높이에 대해 예외가 발생하는가")
    void height_out_of_range_throws_exception(int height) {
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
