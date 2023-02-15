package view.output;

import domain.Ladder;
import domain.Line;
import domain.Participants;
import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행결과\n";

    public void printMap(Participants participants, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        StringBuilder mapResult = new StringBuilder();
        setNames(mapResult, participants);
        setLadder(mapResult, ladder);
        System.out.print(mapResult);
    }

    private void setNames(StringBuilder mapResult, Participants participants) {
        participants.getParticipantsNames();
        for (String participantsName : participants.getParticipantsNames()) {
            mapResult.append(reformatName(participantsName));
        }
        mapResult.append("\n");
    }

    private void setLadder(StringBuilder mapResult, Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            mapResult.append(reformatLadder(line));
        }
    }

    private String reformatName(String name) {
        return String.format("%5s ", name);
    }

    private String reformatLadder(Line line) {
        final String startLine = "    |";
        final String endLine = "|";
        StringBuilder result = new StringBuilder();
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
