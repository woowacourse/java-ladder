package laddergame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameResultTest {

    @Test
    void 리스트에_존재하지않을때_테스트() {
        List<Player> testList = Arrays.asList(new Player("a"), new Player("b"), new Player("c"));
        List<Prize> testList2 = Arrays.asList(new Prize("win"), new Prize("win"), new Prize("lose"));
        String input = "JM";

        assertThrows(IllegalArgumentException.class, () -> GameResult.makeResult(testList, testList2, input));
    }

    @Test
    void 결과_출력_제대로하는지_테스트() {
        List<Player> inputPlayers = Arrays.asList(new Player("a"), new Player("b"), new Player("c"), new Player("d"));
        List<Prize> inputPrizes = Arrays.asList(new Prize("win"), new Prize("win"), new Prize("lose"), new Prize("lose"));

        GameProcessor processor = new GameProcessor(inputPlayers);
        List<List<Boolean>> instructions = Arrays.asList(Arrays.asList(true, false, true), Arrays.asList(false, false, true));
        processor.processGame(instructions);

        String result = GameResult.makeResult(inputPlayers, inputPrizes, "all");
        assertThat(result).isEqualTo("b : win");

       // assertThat(processor.processGame(instructions)).isEqualTo(Arrays.asList(new Player("b"), new Player("a"), new Player("c"), new Player("d")));
    }
}
