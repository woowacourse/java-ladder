package ladder;

import ladder.domain.DrawResult;
import ladder.domain.LadderGame;
import ladder.domain.Player;
import ladder.generator.LadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameApplication {
    public static void main(String[] args) {
        String[] names = InputView.getNames();
        String[] Results = InputView.getDrawResults();
        int countOfLines = InputView.getCountOfLines();

        List<Player> players = Arrays.stream(names).map(Player::new).collect(Collectors.toList());
        List<DrawResult> drawResults = Arrays.stream(Results).map(DrawResult::new).collect(Collectors.toList());
        LadderGame ladderGame = new LadderGame(players, drawResults, new LadderGenerator().makeLadder(players.size(), countOfLines));

        ladderGame.play();

        OutputView.printLadder(ladderGame.toString());

        String message = "";
        while (!message.equals("all")) {
            message = InputView.getResult();
            OutputView.printResult(ladderGame.drawResult(message));
        }
    }
}
