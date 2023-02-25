package ladder.client.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ladder.domain.dto.LadderInfoDto;

/**
 * 사다리 게임의 결과를 출력하는 클래스입니다
 * <p>
 * 사다리를 출력하는 기능과 사람과 결과에 대한 출력을 담당합니다
 */
public class OutputView {

    private static final String ROW_START_SPACE = "    ";
    private static final String NEXT_LINE = System.lineSeparator();
    private static final String NAME_MESSAGE = "%-6s";
    private static final String RESULT_MESSAGE = "%-5s";

    private OutputView() {
    }

    public static void printLadder(LadderInfoDto ladderInfoDto) {
        System.out.println(generateTitleMessage());
        System.out.println(generatePlayerNamesMessage(ladderInfoDto.getPlayerNames()));
        System.out.println(generateLadderMessage(ladderInfoDto.getLadderInfo()));
        System.out.println(generateResultNamesMessage(ladderInfoDto.getResultNames()));
    }

    private static String generateTitleMessage() {
        return "사다리 결과" + NEXT_LINE;
    }

    private static String generatePlayerNamesMessage(List<String> playerNames) {
        return playerNames.stream()
                .map(OutputView::generatePlayerNameMessage)
                .collect(Collectors.joining());
    }

    private static String generatePlayerNameMessage(String playerName) {
        return String.format(NAME_MESSAGE, playerName);
    }

    private static String generateLadderMessage(List<List<Boolean>> ladderInfo) {
        return ladderInfo.stream()
                .map(OutputView::generateRowMessage)
                .collect(Collectors.joining(NEXT_LINE));
    }

    private static String generateRowMessage(List<Boolean> rowInfo) {
        return ROW_START_SPACE + rowInfo.stream()
                .map(OutputView::generatePointMessage)
                .collect(Collectors.joining());
    }

    private static String generatePointMessage(boolean pointInfo) {
        if (pointInfo) {
            return "|-----";
        }
        return "|     ";
    }

    private static String generateResultNamesMessage(List<String> resultNames) {
        return resultNames.stream()
                .map(OutputView::generateResultNameMessage)
                .collect(Collectors.joining());
    }

    private static String generateResultNameMessage(String resultName) {
        return String.format(NAME_MESSAGE, resultName);
    }

    public static void printResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public static void printResults(Map<String, String> results) {
        System.out.println("실행 결과");
        System.out.println(generateResultsMessage(results));
    }

    private static String generateResultsMessage(Map<String, String> results) {
        return results.entrySet()
                .stream()
                .map(OutputView::generateResultMessage)
                .collect(Collectors.joining(NEXT_LINE));
    }

    private static String generateResultMessage(Map.Entry<String, String> result) {
        return result.getKey() + " : " + result.getValue();
    }

    static void printError(Exception e) {
        System.err.println(e.getMessage());
    }
}
