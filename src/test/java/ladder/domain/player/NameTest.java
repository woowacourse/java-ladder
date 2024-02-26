package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("참여자들은 이름을 가진다.")
    void testConstruct() {
        Name name = new Name("pobi");
        assertThat(name.getValue()).isEqualTo("pobi");
    }

    @Nested
    @DisplayName("참가자 이름이 유효하지 않을 경우 예외가 발생한다.")
    class InvalidNameTest {

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "666666"})
        @DisplayName("참여자들의 이름이 범위가 벗어나면 예외가 발생한다.")
        void testInvalidNameRange(String name) {
            assertThatThrownBy(() -> new Name(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"abc!", "!@#"})
        @DisplayName("참여자들의 이름은 영어, 숫자가 아니라면 예외가 발생한다.")
        void testInvalidNameFormat(String name) {
            assertThatThrownBy(() -> new Name(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
