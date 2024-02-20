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
        List<UserName> userNames = List.of(new UserName("a"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserNames(userNames))
                .withMessage(String.format(
                        "사용자는 %d명 이상 %d명 이하여야 합니다", MIN_SIZE, MAX_SIZE
                ));
    }

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
                .withMessage(String.format(
                        "사용자는 %d명 이상 %d명 이하여야 합니다", MIN_SIZE, MAX_SIZE
                ));
    }

    @DisplayName("중복된 이름이 입력되면 예외가 발생한다.")
    @Test()
    void createNameByDuplicated() {
        List<UserName> userNames = List.of(new UserName("kelly"), new UserName("kelly"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserNames(userNames))
                .withMessage("중복된 이름은 허용되지 않습니다.");
    }

    @DisplayName("사용자 수를 반환한다.")
    @Test
    void getUserCount() {
        final UserNames userNames = new UserNames(List.of(new UserName("aaa"), new UserName("bbb")));

        assertThat(userNames.getUserCount())
                .isEqualTo(2);
    }
}
