package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserNameTest {
    @DisplayName("이름의 길이가 5를 초과하면 예외를 던진다")
    @Test
    void createNameByOverLength() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserName("abcdef"))
                .withMessage("이름의 길이는 5 이하여야 합니다.");
    }
}
