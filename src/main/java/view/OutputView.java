package view;

import domain.Line;
import domain.Map;
import domain.Participants;

public class OutputView {

    private static final String ABLE_TO_MOVE = "-----";
    private static final String DISABLE_TO_MOVE = "     ";
    private static final String LINE_START = "    |";
    private static final String BLOCK_DELIMITER = "|";
    private static final String RESULT_MESSAGE = "\n실행결과\n";
    private static final boolean CONNECTED = true;

    public void printMap(Participants participants, Map map) {
        System.out.println(RESULT_MESSAGE);
        StringBuilder mapResult = new StringBuilder();
        setNames(mapResult, participants);
        mapResult.append(System.lineSeparator());
        setLadder(mapResult, map);
        System.out.print(mapResult);
    }

    private void setNames(StringBuilder mapResult, Participants participants) {
        participants.getNames()
            .forEach((participantName) -> mapResult.append(reformatName(participantName)));
    }

    private String reformatName(String name) {
        return String.format("%5s ", name);
    }

    private void setLadder(StringBuilder mapResult, Map map) {
        map.getLines()
            .forEach((line) -> mapResult.append(reformatLine(line)));
    }

    private String reformatLine(Line line) {
        final StringBuilder result = new StringBuilder();
        result.append(LINE_START);
        for (Boolean block : line.getBlocks()) {
            result.append(reformatStatus(block)).append(BLOCK_DELIMITER);
        }
        result.append(System.lineSeparator());
        return result.toString();
    }

    private String reformatStatus(Boolean status) {
        if (status == CONNECTED) {
            return ABLE_TO_MOVE;
        }
        return DISABLE_TO_MOVE;
    }
}
