package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserNamesTest {

    @DisplayName("사용자가 7명을 초과하면 예외가 발생한다.")
    @Test
    void createUserNamesByOverSize() {
        // Given
        List<UserName> userNames = List.of(
                new UserName("a"),
                new UserName("b"),
                new UserName("c"),
                new UserName("d"),
                new UserName("e"),
                new UserName("f"),
                new UserName("g"),
                new UserName("h"),
                new UserName("i")
        );

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserNames(userNames))
                .withMessage("사용자는 7명 이하여야 합니다");
    }

}
