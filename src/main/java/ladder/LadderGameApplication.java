package ladder;

import ladder.domain.DrawResult;
import ladder.domain.LadderGame;
import ladder.domain.Player;
import ladder.generator.LadderGenerator;

import java.util.Arrays;

public class LadderGameApplication {
    public static void main(String[] args) {
        new LadderGame(Arrays.asList(new Player("a")),
                Arrays.asList(new DrawResult("100")),
                new LadderGenerator().makeLadder(2,2)).play();
    }
}
