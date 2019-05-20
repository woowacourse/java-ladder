package ladder.utils;

import ladder.domain.player.Player;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {
    @Test
    void 입력값의_길이_체크() {
        assertThatThrownBy(() -> InputValidator.isWrongLength("pooooooobi,deeeeeenis")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈값_체크() {
        assertThatThrownBy(() -> InputValidator.isWrongLength(" ,denis")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_또는_0_체크() {
        assertThatThrownBy(() -> InputValidator.checkPositive(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.checkPositive(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_이름_체크() {
        assertThatThrownBy(() -> InputValidator.checkValidNames("pobi,pobi")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름으로_받지_말아야_할_값_체크(){
        assertThatThrownBy(()-> InputValidator.checkValidNames("all")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력받은_이름이_참여한_player가_아닌_경우(){
        Set<Player> players = new HashSet<>();
        players.add(new Player("pobi"));
        assertThatThrownBy(()-> InputValidator.checkExistPlayer("denis", players)).isInstanceOf(IllegalArgumentException.class);
    }
}
