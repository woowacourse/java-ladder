package view;

import dto.GameResult;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import model.Ladder;
import model.LadderResults;
import model.Line;
import model.Names;
import model.Path;

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

    public void printNameOfParticipants(Names names) {
        int totalSize = names.getTotalParticipantSize();

        IntStream.range(0, totalSize)
                .mapToObj(index -> calculateNameLog(names.getNameOfIndex(index), totalSize, index))
                .forEach(this::print);
        print(System.lineSeparator());
    }

    public void printLadderResult(LadderResults ladderResults) {
        int totalSize = ladderResults.getResultSize();

        IntStream.range(0, totalSize)
                .mapToObj(index -> mapToLadderResultLog(ladderResults.getLadderResultOfIndex(index), totalSize, index))
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

    private String calculateNameLog(String name, int totalSize, int index) {
        if (isLastParticipant(totalSize, index)){
            return String.format(NORMAL_FORMAT, name);
        }
        return String.format(LAST_FORMAT, name);
    }

    private boolean isLastParticipant(int totalSize, int index) {
        return totalSize - 1 != index;
    }

    public void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        lines.forEach(line -> printLine(line.getLine()));
    }

    private void printLine(List<Path> paths) {
        print(LEFT_LEG);
        paths.forEach(this::printPath);
        print(System.lineSeparator());
    }

    private void printPath(Path path) {
        print(mapToPathLog(path));
        print(LEG);
    }

    private String mapToPathLog(Path path) {
        if (path.isPassable()) {
            return PASSABLE;
        }
        return UN_PASSABLE;
    }

    public void printResultOfName(String gameResult) {
        print(gameResult);
        print(System.lineSeparator());
    }

    public void printTotalResult(List<GameResult> gameResults) {
        String totalResultLog = gameResults.stream()
                .map(result -> String.format(TOTAL_RESULT_FORMAT, result.getName(), result.getLadderResult()))
                .collect(Collectors.joining(System.lineSeparator()));
        print(totalResultLog);
        print(System.lineSeparator());
    }

    public void printExceptionMessage(String message) {
        print(String.format(EXCEPTION_FORMAT, message));
    }

    private void print(String message) {
        System.out.print(message);
    }
}
