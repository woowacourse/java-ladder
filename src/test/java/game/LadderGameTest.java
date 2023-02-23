package game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import model.Ladder;
import model.Players;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import strategy.TruePassGenerator;

class LadderGameTest {

    @Test
    void 참가자_수와_결과_수가_다르면_예외가_발생한다() {
        Ladder ladder = new Ladder(5, new Players(List.of("lee", "kim", "john")), new TruePassGenerator());
        List<String> results = List.of("win", "lose");

        assertThatThrownBy(
            () -> new LadderGame(results, ladder)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"alll", "jay", "", " "})
    void 결과화면_입력에서_all이나_참가자이름을_입력하지_않으면_예외가_발생한다(String targetName) {
        Ladder ladder = new Ladder(5, new Players(List.of("lee", "kim", "john")), new TruePassGenerator());
        List<String> results = List.of("win", "lose", "win");
        LadderGame ladderGame = new LadderGame(results, ladder);

        ladderGame.calculateFinalPosition();

        assertThatThrownBy(
            () -> ladderGame.getFinalPlayerResult(targetName)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
