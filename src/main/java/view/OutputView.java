package view;

import java.util.List;
import java.util.stream.IntStream;
import model.Ladder;
import model.Line;
import model.Names;
import model.Path;

public class OutputView {

    private static final String PARTICIPANT_NAME_FORMAT = "%-5s ";
    private static final String PARTICIPANT_NAME_FORMAT_FOR_LAST_INDEX = "%4s";
    private static final String LEFT_LEG = "    |";
    private static final String LEG = "|";
    private static final String LINE_FEED = "\n";
    private static final int CONVERT_INDEX_VALUE = 1;

    public void noticeInputParticipants() {
        notice("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void noticeInputHeightOfLadder() {
        notice("최대 사다리 높이는 몇 개인가요?");
    }

    public void noticeResult() {
        notice("실행결과");
    }

    private void notice(String message) {
        print(message);
        print(LINE_FEED);
    }

    public void printNameOfParticipants(Names names) {
        int totalSize = names.getTotalParticipantSize();

        IntStream.range(0, totalSize)
                .mapToObj(index -> calculateNameLog(names.getNameOfIndex(index), totalSize, index))
                .forEach(this::print);
        print(LINE_FEED);
    }

    private String calculateNameLog(String name, int totalSize, int index) {
        if (isLastParticipant(totalSize, index)){
            return String.format(PARTICIPANT_NAME_FORMAT, name);
        }
        return String.format(PARTICIPANT_NAME_FORMAT_FOR_LAST_INDEX, name);
    }

    private boolean isLastParticipant(int totalSize, int index) {
        return totalSize - CONVERT_INDEX_VALUE != index;
    }

    public void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        lines.forEach(line -> printLine(line.getLine()));
    }

    private void printLine(List<Path> paths) {
        print(LEFT_LEG);
        paths.forEach(this::printPath);
        print(LINE_FEED);
    }

    private void printPath(Path path) {
        print(path.getLog());
        print(LEG);
    }

    private void print(String message) {
        System.out.print(message);
    }
}
