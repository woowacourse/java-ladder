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
    private static final String MATCH_RESULT_MESSAGE = System.lineSeparator() + "실행 결과" + System.lineSeparator();
    private static final String MATCH_RESULT_ALL_FORMAT = "%s : %s" + System.lineSeparator();

    public void printLadder(Participants participants, Ladder ladder, List<String> results) {
        System.out.println(RESULT_MESSAGE);
        StringBuilder ladderResult = new StringBuilder();
        setNames(ladderResult, participants);
        setLadder(ladderResult, ladder);
        setResult(ladderResult, results);
        System.out.print(ladderResult);
    }

    private void setNames(StringBuilder ladderResult, Participants participants) {
        participants.getParticipantNames()
                    .forEach((participantName) -> ladderResult.append(reformatName(participantName)));
        ladderResult.append(System.lineSeparator());
    }

    private String reformatName(String name) {
        return String.format("%5s ", name);
    }

    private void setLadder(StringBuilder ladderResult, Ladder ladder) {
        ladder.getLines()
               .forEach((line) -> ladderResult.append(reformatLine(line)));
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

    private void setResult(StringBuilder ladderResult, List<String> results) {
        results.forEach((result) -> ladderResult.append(reformatName(result)));
        ladderResult.append(System.lineSeparator());
    }

    public void printMatchAllResult(Map<String, String> matchResult) {
        StringBuilder result = new StringBuilder();
        result.append(MATCH_RESULT_MESSAGE);
        matchResult.forEach((name, reward) ->
                result.append(String.format(MATCH_RESULT_ALL_FORMAT, name, reward)));
        System.out.println(result);
    }

    public void printMatchResult(String matchResult) {
        String result = MATCH_RESULT_MESSAGE + matchResult;
        System.out.println(result);
    }
}
