package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NamesTest {

    @DisplayName("사람 이름이 두 명 이상일 경우 정상적으로 생성된다.")
    @Test
    void create_success() {
        List<Name> names = List.of(new Name("phobi"), new Name("neo"));
        assertThatNoException().isThrownBy(() -> new Names(names));
    }

    @DisplayName("사람 이름이 두 명 미만일 경우 예외를 반환한다.")
    @Test
    void create_fail_by_not_enough_number_of_name() {
        List<Name> names = List.of(new Name("phobi"));
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최소 2개 이상이여햡니다.");
    }

    @DisplayName("사람 이름이 중복되면 예외를 반환한다.")
    @Test
    void create_fail_by_duplicate_name() {
        List<Name> namesInput = List.of(new Name("neo"), new Name("neo"));
        assertThatThrownBy(() -> new Names(namesInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 중복 될 수 없습니다.");
    }

    @DisplayName("getSize()를 통해서 이름의 숫자 갯수를 반환한다.")
    @Test
    void getSize() {
        List<Name> namesInput = List.of(new Name("phobi"), new Name("neo"));
        Names names = new Names(namesInput);
        assertThat(names.getSize()).isEqualTo(2);
    }
}
