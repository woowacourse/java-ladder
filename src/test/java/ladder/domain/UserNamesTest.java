package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.UserNames.MAX_SIZE;
import static ladder.domain.UserNames.MIN_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class UserNamesTest {

    @DisplayName("사용자가 2명 미만이면 예외가 발생한다.")
    @Test
    void createUserNamesByLowerSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> UserNames.of(List.of("a")))
                .withMessage(String.format(
                        "사용자는 %d명 이상 %d명 이하여야 합니다", MIN_SIZE, MAX_SIZE
                ));
    }

    @DisplayName("사용자가 7명을 초과하면 예외가 발생한다.")
    @Test
    void createUserNamesByOverSize() {
        // Given
        List<String> userNames = List.of("a", "b", "c", "d", "e", "f", "g", "h");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> UserNames.of(userNames))
                .withMessage(String.format(
                        "사용자는 %d명 이상 %d명 이하여야 합니다", MIN_SIZE, MAX_SIZE
                ));
    }

    @DisplayName("중복된 이름이 입력되면 예외가 발생한다.")
    @Test()
    void createNameByDuplicated() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> UserNames.of(List.of("kelly", "kelly")))
                .withMessage("중복된 이름은 허용되지 않습니다.");
    }

    @DisplayName("사용자 수를 반환한다.")
    @Test
    void getUserCount() {
        final UserNames userNames = UserNames.of(List.of("aaa", "bbb"));

        assertThat(userNames.getUserCount())
                .isEqualTo(2);
    }
}
