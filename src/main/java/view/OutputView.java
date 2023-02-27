package view;

import domain.LineStatus;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT_MESSAGE = System.lineSeparator() + "사다리 결과" + System.lineSeparator();
    private static final String NAME_FORMAT = "%5s ";
    private static final String START_LINE = "    |";
    private static final String END_LINE = "|";
    private static final String CONNECTED_LINE = "-----";
    private static final String DISCONNECTED_LINE = "     ";
    private static final String MATCH_RESULT_MESSAGE = System.lineSeparator() + "실행 결과" + System.lineSeparator();
    private static final String MATCH_RESULT_ALL_FORMAT = "%s : %s" + System.lineSeparator();

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage() + System.lineSeparator());
    }

    public void printLadder(List<String> participants, List<List<Boolean>> ladder,
                            List<String> results) {
        System.out.println(RESULT_MESSAGE);
        StringBuilder ladderResult = new StringBuilder();
        setNames(ladderResult, participants);
        setLadder(ladderResult, ladder);
        setResult(ladderResult, results);
        System.out.print(ladderResult);
    }

    private void setNames(StringBuilder ladderResult, List<String> participants) {
        participants.forEach((participantName) -> ladderResult.append(reformatName(participantName)));
        ladderResult.append(System.lineSeparator());
    }

    private String reformatName(String name) {
        return String.format(NAME_FORMAT, name);
    }

    private void setLadder(StringBuilder ladderResult, List<List<Boolean>> ladder) {
        ladder.forEach((line) -> ladderResult.append(reformatLine(line)));
    }

    private String reformatLine(List<Boolean> line) {
        final StringBuilder result = new StringBuilder();
        result.append(START_LINE);
        for (Boolean status : line) {
            result.append(reformatStatus(status));
            result.append(END_LINE);
        }
        result.append(System.lineSeparator());
        return result.toString();
    }

    private String reformatStatus(boolean status) {
        if (LineStatus.getStatus(status) == LineStatus.CONNECTED) {
            return CONNECTED_LINE;
        }
        return DISCONNECTED_LINE;
    }

    private void setResult(StringBuilder ladderResult, List<String> results) {
        results.forEach((result) -> ladderResult.append(reformatName(result)));
        ladderResult.append(System.lineSeparator());
    }

    public void printMatchAllResult(Map<String, String> matchResult, List<String> participants) {
        StringBuilder result = new StringBuilder();
        result.append(MATCH_RESULT_MESSAGE);
        participants.forEach(name -> result.append(
                String.format(MATCH_RESULT_ALL_FORMAT, name, matchResult.get(name))));
        System.out.println(result);
    }

    public void printMatchResult(String matchResult) {
        String result = MATCH_RESULT_MESSAGE + matchResult;
        System.out.println(result);
    }
}
