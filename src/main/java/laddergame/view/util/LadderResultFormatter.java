package laddergame.view.util;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.ladder.line.Line;
import laddergame.domain.ladder.line.StepPoint;

public class LadderResultFormatter {

    private static final String VERTICAL = "|";
    private static final String STEP_EXIST = "-";
    private static final String STEP_NONE = " ";

    public static String extractLadderResult(List<String> players, List<Line> lines, List<String> items) {
        int pointWidth = computePointWidth(players, items);

        String formattedPlayers = " " + LadderResultFormatter.extractWords(players, pointWidth);
        String formattedLadder = lines.stream()
                .map(line -> LadderResultFormatter.extractLine(line, pointWidth))
                .collect(Collectors.joining(System.lineSeparator()));
        String formattedResults = " " + LadderResultFormatter.extractWords(items, pointWidth);

        return String.join(System.lineSeparator(), formattedPlayers, formattedLadder, formattedResults);
    }

    private static int computePointWidth(List<String> players, List<String> results) {
        return Math.max(computeWordMaxLength(players), computeWordMaxLength(results));
    }

    private static int computeWordMaxLength(List<String> words) {
        return words.stream()
                .map(String::length)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("변환할 단어가 존재하지 않습니다."));
    }

    private static String extractWords(List<String> words, int pointWidth) {
        return words.stream()
                .map(name -> String.format("%" + pointWidth + "s", name))
                .collect(Collectors.joining(" "));
    }

    private static String extractLine(Line line, int pointWidth) {
        String extracted = line.toStepPointsInLine()
                .stream()
                .map(point -> toStepPointFormat(point, pointWidth))
                .collect(Collectors.joining(VERTICAL, VERTICAL, VERTICAL));
        return toStepPointFormat(StepPoint.NONE, pointWidth) + extracted;
    }

    private static String toStepPointFormat(StepPoint point, int pointWidth) {
        if (point == StepPoint.EXIST) {
            return STEP_EXIST.repeat(pointWidth);
        }
        return STEP_NONE.repeat(pointWidth);
    }

}
