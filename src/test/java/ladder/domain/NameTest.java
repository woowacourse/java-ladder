package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class NameTest {

    @Test
    @DisplayName("이름 길이가 5를 초과하면 예외를 던진다.")
    void should_ThrowException_When_LengthMoreThan5() {
        assertThatThrownBy(() -> new Name("5글자넘어가는이름"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자의 이름은 최대 5글자를 넘을 수 없습니다.");
    }
}
