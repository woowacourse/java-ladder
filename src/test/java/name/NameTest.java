package name;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    @DisplayName("사람의 이름은 1자 이상, 5자 이하가 아니면 예외를 던진다. -> 실패 케이스")
    void name_constructor_validate(String input) {
        // when & then
        Assertions.assertThatThrownBy(() -> new Name(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
