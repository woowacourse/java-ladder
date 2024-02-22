package domain.name;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerNameTest {
    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    void 이름의_길이가_1보다_작거나_5보다_크면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new PlayerName(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
