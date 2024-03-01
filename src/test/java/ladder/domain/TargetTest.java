package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TargetTest {

    @Test
    @DisplayName("all이라는 이름을 생성할 수 있다")
    void allTargetCreateTest() {
        // given
        String all = "all";

        // when
        Target target = new Target(all);

        // then
        assertThat(target)
                .isInstanceOf(Target.class);
    }

    @Test
    @DisplayName("타깃의 이름이 all 이라면 참이다.")
    void isAll() {
        Target target = new Target("all");

        assertThat(target.isAll()).isTrue();
    }

    @Test
    @DisplayName("타깃의 이름이 all 이 아니라면 거짓이다.")
    void isNotAll() {
        Target target = new Target("pobi");

        assertThat(target.isAll()).isFalse();
    }
}
