package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings={"name12", ""})
    @DisplayName("참여자 이름의 길이가 1보다 작거나 5보다 크면 예외가 발생한다.")
    void nameMaxLengthTest(String name) {
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참여자 이름에 영문자와 숫자가 아닌 문자가 포함될 경우 예외가 발생한다.")
    void nameFormatTest() {
        String name = "test!";
        assertThatThrownBy(() -> new Player(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 영문자와 숫자로 구성되어야 합니다.");
    }
}
