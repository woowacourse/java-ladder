package ladder.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NameTest {

    @Test
    void 참여자의_이름은_5자를_초과할_수_없다() {
        assertThatThrownBy(() -> {
            new Name("5글자넘어가는이름");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 참여자의_이름에는_공백이_들어갈_수_없다() {
        assertThatThrownBy(() -> {
            new Name("김 한국");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
