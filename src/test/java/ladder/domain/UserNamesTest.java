package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserNamesTest {

    @DisplayName("사용자가 2명 미만이면 예외가 발생한다.")
    @Test
    void createUserNamesByLowerSize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> UserNames.from(List.of("a")))
                .withMessage("참여자는 2명 이상이어야 합니다.");
    }

    @DisplayName("중복된 이름이 입력되면 예외가 발생한다.")
    @Test()
    void createNameByDuplicated() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> UserNames.from(List.of("kelly", "kelly")))
                .withMessage("중복된 이름은 허용되지 않습니다.");
    }

    @DisplayName("사용자 수를 반환한다.")
    @Test
    void getUserCount() {
        final UserNames userNames = UserNames.from(List.of("aaa", "bbb"));

        assertThat(userNames.getUserCount()).isEqualTo(2);
    }

    @DisplayName("사용자 이름들을 List<String> 형태로 가공하여 반환한다.")
    @Test
    void getUserNames() {
        final UserNames userNames = UserNames.from(List.of("kelly", "liv"));

        assertThat(userNames.getUserNames()).containsExactly("kelly", "liv");
    }

    @DisplayName("전달 받은 이름과 동일한 이름을 가진 사람이 있는지 확인한다")
    @CsvSource(value = {"liv:true", "moly:false"}, delimiter = ':')
    @ParameterizedTest
    void checkSameName(String name, Boolean expected) {
        UserNames userNames = UserNames.from(List.of("kelly", "liv"));

        assertThat(userNames.isExist(name)).isEqualTo(expected);
    }
}
