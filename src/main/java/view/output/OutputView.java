package view.output;

import domain.Line;
import domain.GameMap;
import domain.Participants;

public class OutputView {

    private static final String RESULT_MESSAGE = System.lineSeparator() + "실행결과" + System.lineSeparator();
    private static final String START_LINE = "    |";
    private static final String END_LINE = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String DISCONNECTED_LINE = "     ";

    public void printMap(Participants participants, GameMap gameMap) {
        System.out.println(RESULT_MESSAGE);
        StringBuilder mapResult = new StringBuilder();
        setNames(mapResult, participants);
        setLadder(mapResult, gameMap);
        System.out.print(mapResult);
    }

    private void setNames(StringBuilder mapResult, Participants participants) {
        participants.getParticipantNames()
                    .forEach((participantName) -> mapResult.append(reformatName(participantName)));
        mapResult.replace(mapResult.length() - 2, mapResult.length(), System.lineSeparator());
    }

    private String reformatName(String name) {
        if (name.length() < 5) {
            name += " ";
        }
        return String.format("%5s ", name);
    }

    private void setLadder(StringBuilder mapResult, GameMap gameMap) {
        gameMap.getLines()
               .forEach((line) -> mapResult.append(reformatLine(line)));
    }

    private String reformatLine(Line line) {
        final StringBuilder result = new StringBuilder();
        result.append(START_LINE);
        for (Boolean status : line.getStatus()) {
            result.append(reformatStatus(status));
            result.append(END_LINE);
        }
        result.append(System.lineSeparator());
        return result.toString();
    }

    private String reformatStatus(boolean status) {
        final boolean isConnected = true;
        if (status == isConnected) {
            return CONNECTED_LINE;
        }
        return DISCONNECTED_LINE;
    }
}
