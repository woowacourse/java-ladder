package ladder;

import ladder.domain.Command;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.Line;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Result;
import ladder.domain.Results;
import ladder.domain.Step;
import ladder.domain.strategy.linestrategy.LineStrategy;
import ladder.domain.strategy.linestrategy.RandomLineStrategy;
import ladder.view.InputView;
import ladder.view.OutputView;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final Boolean FINISH = false;
    private static final Boolean PROCEED = true;

    private static Players players;
    private static Results results;
    private static Height height;
    private static final LineStrategy lineStrategy = new RandomLineStrategy();
    private static LadderFactory ladderFactory;
    private static Ladder ladder;

    public static void main(String[] args) {
        players = new Players(InputView.readPlayerNames());
        results = new Results(InputView.readResults(), players.getPlayersCount());
        height = new Height(InputView.readLadderHeight());
        ladderFactory = new LadderFactory(height, players, lineStrategy);
        ladder = ladderFactory.makeLadder();

        OutputView.printLadder(
                playersToString(players.getPlayers()),
                ladderToString(ladder.getLines()),
                resultsToString(results.getResults()));
        askResult();
    }

    private static List<String> playersToString(List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    private static List<List<String>> ladderToString(List<Line> lines) {
        return lines.stream()
                .map(line -> line.getSteps().stream()
                        .map(Step::getShape)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static List<String> resultsToString(List<Result> results) {
        return results.stream()
                .map(Result::getResult)
                .collect(Collectors.toList());
    }

    private static void askResult() {
        boolean proceed = true;
        while (proceed) {
            String input = InputView.readTargetName();
            proceed = isQuit(input);
            proceed = printResult(proceed, input);
        }
    }

    private static boolean isQuit(String input) {
        if (Command.isQuit(input)) {
            return FINISH;
        }
        return PROCEED;
    }

    private static boolean printResult(boolean proceed, String input) {
        if (proceed == FINISH) {
            return FINISH;
        }
        if (Command.isAll(input)) {
            OutputView.printAllResult(players.getPlayerNames(), results.findAllResult(ladder));
            return FINISH;
        }
        OutputView.printSingleResult(results.findResult(ladder, players.findPosition(input)));
        return PROCEED;
    }
}
