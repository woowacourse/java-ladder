package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

}