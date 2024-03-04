package domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    void 이름의_길이가_1보다_작거나_5보다_크면_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예약된_키워드를_이름으로_입력하면_예외가_발생한다() {
        String reserved = "all";
        assertThatThrownBy(() -> new Name(reserved))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
