package view.output;

import domain.Line;
import domain.Map;
import domain.Participants;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행결과\n";

    public void printMap(Participants participants, Map map) {
        System.out.println(RESULT_MESSAGE);
        StringBuilder mapResult = new StringBuilder();
        setNames(mapResult, participants);
        setLadder(mapResult, map);
        System.out.print(mapResult);
    }

    private void setNames(StringBuilder mapResult, Participants participants) {
        participants.getParticipantsNames()
            .forEach((participantName) -> mapResult.append(reformatName(participantName)));
        mapResult.replace(mapResult.length() - 2, mapResult.length(), System.lineSeparator());
    }

    private String reformatName(String name) {
        if (name.length() < 5) {
            name += " ";
        }
        return String.format("%5s ", name);
    }

    private void setLadder(StringBuilder mapResult, Map map) {
        map.getLines().forEach((line) -> mapResult.append(reformatLine(line)));
    }

    private String reformatLine(Line line) {
        final StringBuilder result = new StringBuilder();
        final String startLine = "    |";
        final String endLine = "|";
        result.append(startLine);
        for (Boolean status : line.getStatus()) {
            result.append(reformatStatus(status));
            result.append(endLine);
        }
        result.append(System.lineSeparator());
        return result.toString();
    }

    private String reformatStatus(Boolean status) {
        final boolean isConnected = true;
        final String connected = "-----";
        final String disConnected = "     ";
        if (status == isConnected) {
            return connected;
        }
        return disConnected;
    }
}
