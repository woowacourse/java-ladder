package view;

import domain.ladder.Bridge;
import domain.ladder.Floor;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    private static final String NAME_DELIMITER = " ";
    private static final String FIRST_COLUMN = "    |";
    private static final String COLUMN = "|";

    public void printResultMessage() {
        System.out.println(System.lineSeparator() + "실행결과");
    }

    public void printPlayers(List<String> names) {
        StringJoiner nameJoiner = new StringJoiner(NAME_DELIMITER);
        for (final String name : names) {
            nameJoiner.add(String.format("%5s", name));
        }
        System.out.println(System.lineSeparator() + nameJoiner);
    }

    public void printLadder(List<Floor> ladder) {
        StringJoiner ladderShapeJoiner = new StringJoiner(System.lineSeparator());
        for (final Floor bridges : ladder) {
            ladderShapeJoiner.add(getBridgesShape(bridges));
        }
        System.out.println(ladderShapeJoiner);
    }

    private static String getBridgesShape(final Floor bridges) {
        StringJoiner bridgesShapeJoiner = new StringJoiner(COLUMN, FIRST_COLUMN, COLUMN);
        for (Bridge bridge : bridges.getBridges()) {
            bridgesShapeJoiner.add(BridgeShape.convertForView(bridge));
        }
        return bridgesShapeJoiner.toString();
    }
}
