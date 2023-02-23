package ladder.domain.ladder;

import ladder.util.MoveDirection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveDirectionTest {

    @Test
    @DisplayName("오른쪽 bar가 true 이면 1을 반환한다.")
    void test_1() {
        // then
        Assertions.assertThat(MoveDirection.directMove(Bar.FALSE,Bar.TRUE)).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽 bar가 true 이면 -1을 반환한다.")
    void test_2() {
        // then
        Assertions.assertThat(MoveDirection.directMove(Bar.TRUE,Bar.FALSE)).isEqualTo(-1);
    }

    @Test
    @DisplayName("양쪽 bar가 false 이면 0을 반환한다.")
    void test_3() {
        // then
        Assertions.assertThat(MoveDirection.directMove(Bar.FALSE,Bar.FALSE)).isEqualTo(0);
    }
}
