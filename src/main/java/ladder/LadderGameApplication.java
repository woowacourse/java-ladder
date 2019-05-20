package ladder;

import ladder.domain.*;
import ladder.generator.LadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGameApplication {

    private static final String STOP_MESSAGE = "all";
    private static final String BLANK = "";

    public static void main(String[] args) {
        List<Player> players = Arrays.stream(InputView.getNames())
                .map(Player::new)
                .collect(Collectors.toList());
        List<DrawResult> drawResults = Arrays.stream(InputView.getDrawResults())
                .map(DrawResult::new)
                .collect(Collectors.toList());
        int countOfLines = InputView.getCountOfLines();

        Ladder ladder = LadderGenerator.makeLadder(players.size(), countOfLines);
        LadderGame ladderGame = new LadderGame(ladder);
        GameResult gameResult = ladderGame.play(players, drawResults);

        OutputView.printLadder(ladder, players, drawResults);

        String message = BLANK;

        while (!message.equals(STOP_MESSAGE)) {
            message = InputView.getResult();
            OutputView.printResult(gameResult.getResult(message));
        }

    }
}