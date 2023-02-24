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
public class PlayerNameTest {

    @ParameterizedTest(name = "이름이 비어있거나 6자 이상인 경우 예외를 던진다. 입력값: \"{0}\"")
    @NullAndEmptySource
    @ValueSource(strings = {"우아한형제들"})
    void 이름이_비어있거나_6자_이상인_경우_예외를_던진다(final String name) {
        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상, 5자 이하여야 합니다.");
    }

    @Test
    void 이름이_정상적으로_생성한다() {
        final PlayerName name = new PlayerName("name");

        assertThat(name.getValue()).isEqualTo("name");
    }

    @Test
    void all을_이름으로_사용할_수_없다() {
        assertThatThrownBy(() -> new PlayerName("all"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("all은 사용할 수 없는 이름입니다.");
    }
}
