package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PeopleTest {

    @Test
    @DisplayName("사람은 최소 2명 참가해야한다.")
    void createPersonGroup() {
        List<String> names = List.of("moly", "loky");
        assertThatCode(() -> People.from(names));
    }

    @Test
    @DisplayName("사람은 최소 2명 참가해야한다.")
    void createPersonGroupThrowExceptionWhenPeopleSizeUnderTwo() {
        List<String> names = List.of("loky");
        assertThatThrownBy(() -> People.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사람은 최소 2명 참가해야 합니다.");
    }

    @Test
    @DisplayName("중복된 사람이름은 존재할 수 없다.")
    void validateDuplicatedPersonNames() {
        List<String> names = List.of("loky", "loky", "moly");
        assertThatThrownBy(() -> People.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 사람이름은 존재할 수 없습니다. loky 라는 이름이 중복되었습니다.");
    }
}
