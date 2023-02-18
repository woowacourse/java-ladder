package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class PlayerTest {

    @Test
    void 참여자는_이름을_가진다() {
        final Player player = new Player("name");

        assertThat(player.getName()).isEqualTo("name");
    }

    @ParameterizedTest(name = "6자 이상인 경우 예외를 던진다. 입력값: \"{0}\"")
    @ValueSource(strings = {"우아한형제들", "우아한테크코스"})
    void 이름이_6자_이상인_경우_예외를_던진다(final String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상, 5자 이하여야 합니다.");
    }

    @ParameterizedTest(name = "이름이 비어있거나 null인 경우 예외를 던진다. 입력값: \"{0}\"")
    @NullAndEmptySource
    void 이름이_비어있거나_null인_경우_예외를_던진다(final String name) {
        assertThatThrownBy(() -> new Player(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상, 5자 이하여야 합니다.");
    }
}
