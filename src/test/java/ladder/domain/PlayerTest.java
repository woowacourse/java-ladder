package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("이름이 1글자 미만이면 예외가 발생한다.")
    @Test
    void validateNotEmpty() {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player(""));
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 예외가 발생한다.")
    void validateMaxLength() {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("honux1"));
    }

    @Test
    @DisplayName("이름이 'all'이면 예외가 발생한다.")
    void validateNotAll() {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Player("all"));
    }

    @DisplayName("참여자를 생성한다.")
    @Test
    void createPlayer() {
        // when
        Player player = new Player("pobi");

        // then
        assertThat(player).extracting("name").isEqualTo("pobi");
    }

    @DisplayName("이름이 동일하면 같은 참여자로 취급한다.")
    @Test
    void equals() {
        // when
        Player player1 = new Player("pobi");
        Player player2 = new Player("pobi");

        // then
        assertThat(player1).isEqualTo(player2);
    }
}
