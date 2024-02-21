package ladder.domain;

import static ladder.domain.UserNames.MIN_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserNamesTest {

    @DisplayName("사용자가 2명 미만이면 예외가 발생한다.")
    @Test
    void createUserNamesByLowerSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> UserNames.of(List.of("a")))
                .withMessage(String.format(
                        "참여자는 %d명 이상이어야 합니다.", MIN_SIZE
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

    @DisplayName("사용자 이름들을 List<String> 형태로 가공하여 반환한다.")
    @Test
    void getUserNames() {
        final UserNames userNames = UserNames.of(List.of("kelly", "liv"));

        assertThat(userNames.getUserNames())
                .containsExactly("kelly", "liv");
    }
}
