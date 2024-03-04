package domain.prize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PrizeTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void 실행결과의_길이가_1보다_작거나_5보다_크면_예외가_발생한다(String name) {
        Assertions.assertThatThrownBy(() -> new Prize(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
