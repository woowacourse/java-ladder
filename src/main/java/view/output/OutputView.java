package view.output;

import domain.Ladder;
import domain.Line;
import domain.Participants;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT_MESSAGE = System.lineSeparator() + "사다리 결과" + System.lineSeparator();
    private static final String START_LINE = "    |";
    private static final String END_LINE = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String DISCONNECTED_LINE = "     ";

    public void printMap(Participants participants, Ladder ladder, List<String> results) {
        System.out.println(RESULT_MESSAGE);
        StringBuilder mapResult = new StringBuilder();
        setNames(mapResult, participants);
        setLadder(mapResult, ladder);
        setResult(mapResult, results);
        System.out.print(mapResult);
    }

    private void setNames(StringBuilder mapResult, Participants participants) {
        participants.getParticipantNames()
                    .forEach((participantName) -> mapResult.append(reformatName(participantName)));
        mapResult.append(System.lineSeparator());
    }

    private String reformatName(String name) {
        return String.format("%5s ", name);
    }

    private void setLadder(StringBuilder mapResult, Ladder ladder) {
        ladder.getLines()
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

    private void setResult(StringBuilder mapResult, List<String> results) {
        results.forEach((result) -> mapResult.append(reformatName(result)));
        mapResult.append(System.lineSeparator());
    }
}
