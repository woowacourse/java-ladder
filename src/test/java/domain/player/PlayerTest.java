package domain.player;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"프", "프린프린프린"})
    void 이름의_길이가_범위를_벗어나면_객체를_생성할_때_예외가_발생한다(String name) {
        // when & then
        assertThatThrownBy(() -> new Player(name))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"프린", "프린프린프"})
    void 이름의_길이가_올바르면_객체를_생성할_때_예외가_발생하지_않는다(String name) {
        // when & then
        assertThatCode(() -> new Player(name))
                .doesNotThrowAnyException();
    }
}
