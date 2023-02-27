package game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.LadderGame;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @Test
    void 참가자_수와_결과_수가_다르면_예외가_발생한다() {
        List<String> results = List.of("win", "lose");

        assertThatThrownBy(
            () -> new LadderGame(results, List.of("kim", "lee", "john"))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
