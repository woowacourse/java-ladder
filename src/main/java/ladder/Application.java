package ladder;

import static java.util.stream.Collectors.joining;
import static ladder.view.InputView.readLadderHeight;
import static ladder.view.InputView.readPlayerNames;
import static ladder.view.InputView.readResults;
import static ladder.view.InputView.readTargetName;
import static ladder.view.OutputView.printAllResult;
import static ladder.view.OutputView.printLadder;
import static ladder.view.OutputView.printSingleResult;

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
import java.util.List;

public class Application {
    private static final String QUIT = "q";
    private static final String ALL = "all";
    private static final Boolean FINISH = false;
    private static final Boolean PROCEED = true;

    private static Players players;
    private static Results results;
    private static Height height;
    private static final LineStrategy lineStrategy = new RandomLineStrategy();
    private static LadderFactory ladderFactory;
    private static Ladder ladder;

    public static void main(String[] args) {
        players = new Players(readPlayerNames());
        results = new Results(readResults(), players.getPlayersCount());
        height = new Height(readLadderHeight());
        ladderFactory = new LadderFactory(height, players, lineStrategy);
        ladder = ladderFactory.makeLadder();

        printLadder(playersToNames(players.getPlayers()),
                ladderToString(ladder.getLines()),
                resultsToString(results.getResults()));
        askResult();
    }

    private static String playersToNames(List<Player> players) {
        return players.stream()
                .map(Player::getName)
                .map(name -> String.format("%-5s", name))
                .collect(joining(" "));
    }

    private static String ladderToString(List<Line> lines) {
        return lines.stream()
                .map(line -> "|" + line.getSteps().stream()
                        .map(Step::getShape)
                        .collect(joining("|")) + "|")
                .collect(joining(System.lineSeparator()));
    }

    private static String resultsToString(List<Result> results) {
        return results.stream()
                .map(Result::getResult)
                .map(result -> String.format("%-5s", result))
                .collect(joining(" "));
    }

    private static void askResult() {
        boolean proceed = true;
        while (proceed) {
            String input = readTargetName();
            proceed = isQuit(input);
            proceed = isAll(proceed, input);
            isSingleResult(proceed, input);
        }
    }

    private static boolean isQuit(String input) {
        if (input.equals(QUIT)) {
            return FINISH;
        }
        return PROCEED;
    }

    private static boolean isAll(boolean proceed, String input) {
        if (proceed && input.equals(ALL)) {
            printAllResult(toAllResult(players.getPlayerNames(), results.findAllResult(ladder)));
            return FINISH;
        }
        return PROCEED;
    }

    private static String toAllResult(List<String> players, List<String> allResult) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            stringBuilder.append(players.get(i) + " : " + allResult.get(i) + System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static void isSingleResult(boolean proceed, String playerName) {
        if (proceed) {
            printSingleResult(results.findResult(ladder, players.findPosition(playerName)));
        }
    }
}
