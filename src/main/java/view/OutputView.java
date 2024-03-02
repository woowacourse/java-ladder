package view;

import domain.GameResult;
import domain.GameResults;
import domain.Results;
import domain.ladder.Bridge;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.PlayerNames;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String VALUE_DELIMITER = " ";
    private static final String FIRST_COLUMN = "    |";
    private static final String COLUMN = "|";
    private static final String NAME_RESULT_SEPARATOR = " : ";

    private OutputView() {
    }

    public static void printGameBoard(final PlayerNames playerNames, final Ladder ladder, final Results results) {
        System.out.println(System.lineSeparator() + "실행결과");
        printWithFormat(playerNames.getValues());
        printLadder(ladder);
        printWithFormat(results.getValues());
    }

    private static void printWithFormat(List<String> values) {
        StringJoiner valueJoiner = new StringJoiner(VALUE_DELIMITER);
        for (final String value : values) {
            valueJoiner.add(String.format("%5s", value));
        }
        System.out.println(System.lineSeparator() + valueJoiner);
    }

    private static void printLadder(Ladder ladder) {
        StringJoiner floorJoiner = new StringJoiner(System.lineSeparator());
        for (final Floor floor : ladder.getFloors()) {
            floorJoiner.add(getFloorShape(floor));
        }
        System.out.print(floorJoiner);
    }

    private static String getFloorShape(final Floor floor) {
        StringJoiner bridgeJoiner = new StringJoiner(COLUMN, FIRST_COLUMN, COLUMN);
        for (Bridge bridge : floor.getBridges()) {
            bridgeJoiner.add(BridgeShape.convertForView(bridge));
        }
        return bridgeJoiner.toString();
    }

    public static void printGameResult(GameResult gameResult) {
        System.out.println(System.lineSeparator() + "실행 결과");
        System.out.println(gameResult.result());
    }

    public static void printGameResults(GameResults gameResults) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (int index = 0; index < gameResults.count(); index++) {
            final GameResult gameResult = gameResults.findBy(index);
            System.out.println(gameResult.playerName() + NAME_RESULT_SEPARATOR + gameResult.result());
        }
    }
}
