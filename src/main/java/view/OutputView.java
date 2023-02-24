package view;

import dto.GameResultDto;
import dto.LineDto;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String EXCEPTION_FORMAT = "[ERROR] %s";
    private static final String HANGUL_PATTERN = "[ㄱ-ㅎㅏ-ㅣ가-힣\\s]+";
    private static final String NORMAL_FORMAT = "%-6s";
    private static final String LAST_FORMAT = "%4s";
    private static final String KOREAN_NORMAL_FORMAT = "%-5s";
    private static final String KORAN_LAST_FORMAT = "%3s";
    private static final String TOTAL_RESULT_FORMAT = "%s : %s";
    private static final String LEFT_LEG = "    |";
    private static final String LEG = "|";
    private static final String PASSABLE = "-----";
    private static final String UN_PASSABLE = "     ";
    private static final int DEFAULT_GAME_RESULT_SIZE = 1;
    private static final int ONLY_ONE_GAME_RESULT_INDEX = 0;

    public void noticeInputParticipants() {
        notice("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void noticeInputLadderResult() {
        print(System.lineSeparator());
        notice("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void noticeInputHeightOfLadder() {
        print(System.lineSeparator());
        notice("최대 사다리 높이는 몇 개인가요?");
    }

    public void noticeLadderResult() {
        print(System.lineSeparator());
        notice("사다리 결과");
        print(System.lineSeparator());
    }

    public void noticeFindResultOfName() {
        print(System.lineSeparator());
        notice("결과를 보고 싶은 사람은?");
    }

    public void noticeGameResult() {
        print(System.lineSeparator());
        notice("실행결과");
    }

    private void notice(String message) {
        print(message);
        print(System.lineSeparator());
    }

    public void printNameOfParticipants(List<String> nameInfo) {
        int totalSize = nameInfo.size();

        IntStream.range(0, totalSize)
                .mapToObj(index -> calculateNameLog(nameInfo.get(index), totalSize, index))
                .forEach(this::print);
        print(System.lineSeparator());
    }

    private String calculateNameLog(String name, int totalSize, int index) {
        if (isLastParticipant(totalSize, index)){
            return String.format(NORMAL_FORMAT, name);
        }
        return String.format(LAST_FORMAT, name);
    }

    private boolean isLastParticipant(int totalSize, int index) {
        return totalSize - 1 != index;
    }

    public void printLadder(List<LineDto> ladder) {
        ladder.forEach(line -> printLine(line.getPaths()));
    }

    private void printLine(List<Boolean> paths) {
        print(LEFT_LEG);
        paths.forEach(this::printPath);
        print(System.lineSeparator());
    }

    private void printPath(boolean passable) {
        print(mapToPathLog(passable));
        print(LEG);
    }

    private String mapToPathLog(boolean passable) {
        if (passable) {
            return PASSABLE;
        }
        return UN_PASSABLE;
    }

    public void printLadderResult(List<String> ladderResults) {
        int totalSize = ladderResults.size();

        IntStream.range(0, totalSize)
                .mapToObj(index -> mapToLadderResultLog(ladderResults.get(index), totalSize, index))
                .forEach(this::print);
        print(System.lineSeparator());
    }

    private String mapToLadderResultLog(String ladderResult, int totalSize, int index) {
        if (totalSize - 1 == index) {
            return mapToLastIndexLog(ladderResult);
        }
        return mapToNormalIndexLog(ladderResult);
    }

    private String mapToNormalIndexLog(String ladderResult) {
        if (ladderResult.matches(HANGUL_PATTERN)) {
            return String.format(KOREAN_NORMAL_FORMAT, ladderResult);
        }
        return String.format(NORMAL_FORMAT, ladderResult);
    }

    private String mapToLastIndexLog(String ladderResult) {
        if (ladderResult.matches(HANGUL_PATTERN)) {
            return String.format(KORAN_LAST_FORMAT, ladderResult);
        }
        return String.format(LAST_FORMAT, ladderResult);
    }

    public void printLadderGameResult(List<GameResultDto> gameResults) {
        String totalResultLog = mapToTotalGameResultLog(gameResults);

        print(totalResultLog);
        print(System.lineSeparator());
    }

    private String mapToTotalGameResultLog(List<GameResultDto> gameResults) {
        if (gameResults.size() == DEFAULT_GAME_RESULT_SIZE) {
            return gameResults.get(ONLY_ONE_GAME_RESULT_INDEX).getLadderResult();
        }
        return gameResults.stream()
                .map(this::mapToParticipantResultLog)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String mapToParticipantResultLog(GameResultDto gameResultDto) {
        return String.format(TOTAL_RESULT_FORMAT, gameResultDto.getParticipantName(), gameResultDto.getLadderResult());
    }

    public void printExceptionMessage(String message) {
        print(String.format(EXCEPTION_FORMAT, message));
        print(System.lineSeparator());
    }

    private void print(String message) {
        System.out.print(message);
    }
}
