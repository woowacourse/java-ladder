package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @Test
    void input_안의_이름이_중복되면_예외가_발생한다() {
        assertThatThrownBy(
            () -> new Players(List.of("lee", "kim", "lee"))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 생성자_파라미터_리스트_길이가_2_미만이면_예외가_발생한다() {
        assertThatThrownBy(
            () -> new Players(List.of("lee"))
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
