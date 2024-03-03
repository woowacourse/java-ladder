package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NameTest {

    @Test
    @DisplayName("all이라는 이름을 생성할 수 있다")
    void name_All_isNameInstance() {
        // given
        String all = "all";

        // when
        Name name = new Name(all);

        // then
        assertThat(name)
                .isInstanceOf(Name.class);
    }

    @Test
    @DisplayName("타깃의 이름이 all 이라면 참이다.")
    void name_IsAll_True() {
        Name name = new Name("all");

        assertThat(name.isAll()).isTrue();
    }

    @Test
    @DisplayName("타깃의 이름이 all 이 아니라면 거짓이다.")
    void name_IsAll_False() {
        Name name = new Name("pobi");

        assertThat(name.isAll()).isFalse();
    }
}
