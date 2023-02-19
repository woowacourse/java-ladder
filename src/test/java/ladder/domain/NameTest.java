package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NameTest {

    @Test
    void 참여자의_이름은_5자를_초과할_수_없다() {
        assertThatThrownBy(() -> new Name("5글자넘어가는이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자의 이름은 최대 5글자를 넘을 수 없습니다.");
    }
}
