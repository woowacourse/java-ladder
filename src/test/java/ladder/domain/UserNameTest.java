package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserNameTest {
    @DisplayName("이름의 길이가 5를 초과하면 예외를 던진다")
    @Test
    void createNameByOverLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserName("abcdef"))
                .withMessage("이름의 길이는 5 이하여야 합니다.");
    }

    @DisplayName("유효하지 않은 특수문자가 포함된 이름이 입력되면 예외가 발생한다.")
    @ValueSource(strings = {"kel!", "liv#", "liv,k", "liv\\k"})
    @ParameterizedTest()
    void createNameByInvalidCharacter(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserName(name))
                .withMessage("이름에는 한글, 영문, 숫자, `-`, `_`, `&`만 포함될 수 있습니다.");
    }

    @DisplayName("공백을 입력하면 예외가 발생한다.")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    @ParameterizedTest
    void createNameByEmpty(final String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserName(name))
                .withMessage("이름에 공백을 입력할 수 없습니다");
    }
}
