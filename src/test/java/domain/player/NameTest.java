package domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "123456"})
    void 이름의_길이가_2보다_작거나_5보다_크면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
