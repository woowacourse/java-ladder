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
    void create_fail() {
        List<Name> names = List.of(new Name("phobi"));
        assertThatThrownBy(() -> new Names(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getSize()를 통해서 이름의 숫자 갯수를 반환한다.")
    @Test
    void getSize() {
        List<Name> namesInput = List.of(new Name("phobi"), new Name("neo"));
        Names names = new Names(namesInput);
        assertThat(names.getSize()).isEqualTo(2);
    }
}