package ladder.client.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 사다리 게임의 결과를 출력하는 클래스입니다
 * <p>
 * 사다리를 출력하는 기능과 사람과 결과에 대한 출력을 담당합니다
 */
public class OutputView {

    private static final String ROW_START_SPACE = "    ";
    private static final String NEXT_LINE = System.lineSeparator();
    private static final String NAME_MESSAGE = "%-6s";

    public OutputView() {
    }

    public void printLadderTitle() {
        System.out.println(generateTitleMessage());
    }

    public void printPlayerNames(List<String> playerNames) {
        System.out.println(generatePlayerNamesMessage(playerNames));
    }

    public void printLadderRows(List<List<Boolean>> ladderRows) {
        System.out.println(generateLadderMessage(ladderRows));
    }

    public void printResultNames(List<String> resultNames) {
        System.out.println(generateResultNamesMessage(resultNames));
    }

    private String generateTitleMessage() {
        return "사다리 결과" + NEXT_LINE;
    }

    private String generatePlayerNamesMessage(List<String> playerNames) {
        return playerNames.stream()
                .map(this::generatePlayerNameMessage)
                .collect(Collectors.joining());
    }

    private String generatePlayerNameMessage(String playerName) {
        return String.format(NAME_MESSAGE, playerName);
    }

    private String generateLadderMessage(List<List<Boolean>> ladderInfo) {
        return ladderInfo.stream()
                .map(this::generateRowMessage)
                .collect(Collectors.joining(NEXT_LINE));
    }

    private String generateRowMessage(List<Boolean> rowInfo) {
        return ROW_START_SPACE + rowInfo.stream()
                .map(this::generatePointMessage)
                .collect(Collectors.joining());
    }

    private String generatePointMessage(boolean pointInfo) {
        if (pointInfo) {
            return "|-----";
        }
        return "|     ";
    }

    private String generateResultNamesMessage(List<String> resultNames) {
        return resultNames.stream()
                .map(this::generateResultNameMessage)
                .collect(Collectors.joining());
    }

    private String generateResultNameMessage(String resultName) {
        return String.format(NAME_MESSAGE, resultName);
    }

    public void printResult(String result) {
        System.out.println("실행 결과");
        if (result == null) {
            System.out.println("결과가 없는 사람입니다");
            return;
        }
        System.out.println(result);
    }

    public void printResults(Map<String, String> results) {
        System.out.println("실행 결과");
        System.out.println(generateResultsMessage(results));
    }

    private String generateResultsMessage(Map<String, String> results) {
        return results.entrySet()
                .stream()
                .map(this::generateResultMessage)
                .collect(Collectors.joining(NEXT_LINE));
    }

    private String generateResultMessage(Map.Entry<String, String> result) {
        return result.getKey() + " : " + result.getValue();
    }

    public void printError(Exception e) {
        System.err.println(e.getMessage());
    }
}
