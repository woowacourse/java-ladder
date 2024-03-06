package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGame;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.Point;
import ladder.domain.player.Name;
import ladder.domain.player.Players;
import ladder.domain.result.PlayResults;
import ladder.domain.result.Result;
import ladder.domain.result.Results;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {

    private static final String LADDER_SIDE_SYMBOL = "|";
    private static final int LADDER_WIDTH = 5;
    private static final String FORMAT = "%6s";

    public void printError(String message) {
        System.out.println(message);
    }

    public void printGame(LadderGame ladderGame) {
        printPlayers(ladderGame.getPlayers());
        printLadder(ladderGame.getLadder());
        printResults(ladderGame.getResults());
    }

    private void printPlayers(Players players) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();

        for (Name name : players.getNames()) {
            String formattedName = String.format(FORMAT, name);
            System.out.print(formattedName);
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        ladder.getLadder()
                .forEach(this::printLine);
    }

    private void printLine(Line line) {
        String prefixLadder = " ".repeat(LADDER_WIDTH) + LADDER_SIDE_SYMBOL;
        List<Point> points = line.getPoints();
        StringJoiner formattedLadder = new StringJoiner(LADDER_SIDE_SYMBOL, prefixLadder, LADDER_SIDE_SYMBOL);
        for (int i = 0; i < points.size() - 1; i++) {
            String ladder = points.get(i).repeatSymbol(LADDER_WIDTH);
            formattedLadder.add(ladder);
        }
        System.out.println(formattedLadder);
    }

    private void printResults(Results results) {
        for (Result result : results.getResults()) {
            String formattedResult = String.format(FORMAT, result);
            System.out.print(formattedResult);
        }
        System.out.println();
    }

    public void printPlayResult(PlayResults playResults) {
        System.out.println();
        System.out.println("실행결과");
        Map<Name, Result> value = playResults.getValue();
        if (value.size() == 1) {
            value.values().forEach(result -> System.out.println(result.toString()));
            return;
        }
        value.forEach(this::printAllFormattedResult);
    }

    private void printAllFormattedResult(Name name, Result result) {
        StringJoiner stringJoiner = new StringJoiner(" : ");
        String formattedResult = stringJoiner.add(name.toString())
                .add(result.toString())
                .toString();
        System.out.println(formattedResult);
    }
}
