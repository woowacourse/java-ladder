package view;

import domain.GameResult;
import domain.GameResults;
import domain.Results;
import domain.ladder.Bridge;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.Names;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String NAME_DELIMITER = " ";
    private static final String FIRST_COLUMN = "    |";
    private static final String COLUMN = "|";
    private static final String RESULT_SEPARATOR = " : ";

    private OutputView() {
    }

    public static void printGameBoard(final Names names, final Ladder ladder, final Results results) {
        printResultMessage();
        printWithFormat(names.getValues());
        printLadder(ladder);
        printWithFormat(results.getValues());
    }

    private static void printResultMessage() {
        System.out.println(System.lineSeparator() + "실행결과");
    }

    private static void printWithFormat(List<String> names) {
        StringJoiner nameJoiner = new StringJoiner(NAME_DELIMITER);
        for (final String name : names) {
            nameJoiner.add(String.format("%5s", name));
        }
        System.out.println(System.lineSeparator() + nameJoiner);
    }

    private static void printLadder(Ladder ladder) {
        StringJoiner ladderShapeJoiner = new StringJoiner(System.lineSeparator());
        for (final Floor bridges : ladder.getLadder()) {
            ladderShapeJoiner.add(getBridgesShape(bridges));
        }
        System.out.print(ladderShapeJoiner);
    }

    private static String getBridgesShape(final Floor bridges) {
        StringJoiner bridgesShapeJoiner = new StringJoiner(COLUMN, FIRST_COLUMN, COLUMN);
        for (Bridge bridge : bridges.getBridges()) {
            bridgesShapeJoiner.add(BridgeShape.convertForView(bridge));
        }
        return bridgesShapeJoiner.toString();
    }

    public static void printResult(GameResult gameResult) {
        System.out.println(System.lineSeparator() + "실행 결과");
        System.out.println(gameResult.result());
    }

    public static void printResults(GameResults gameResults) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (int index = 0; index < gameResults.count(); index++) {
            final GameResult gameResult = gameResults.findByIndex(index);
            System.out.println(gameResult.name() + RESULT_SEPARATOR + gameResult.result());
        }
    }
}
