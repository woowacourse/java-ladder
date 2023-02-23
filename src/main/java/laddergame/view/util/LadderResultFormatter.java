package laddergame.view.util;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import laddergame.domain.ladder.line.Direction;
import laddergame.domain.ladder.line.Line;
import laddergame.domain.ladder.line.StepPoint;

public class LadderResultFormatter {

    private static final String VERTICAL = "|";
    private static final String STEP_EXIST = "-";
    private static final String STEP_NONE = " ";

    public static String extractLadderResult(List<String> players, List<Line> lines, List<String> results) {
        int pointWidth = computePointWidth(players, results);

        String formattedPlayers = " " + LadderResultFormatter.extractWords(players, pointWidth);
        String formattedLadder = lines.stream()
                .map(line -> LadderResultFormatter.extractLine(line, pointWidth))
                .collect(Collectors.joining(System.lineSeparator()));
        String formattedResults = " " + LadderResultFormatter.extractWords(results, pointWidth);

        return String.join(System.lineSeparator(), formattedPlayers, formattedLadder, formattedResults);
    }

    private static int computePointWidth(List<String> players, List<String> results) {
        return Math.max(computeWordMaxLength(players), computeWordMaxLength(results));
    }

    private static int computeWordMaxLength(List<String> players) {
        return players.stream()
                .map(String::length)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("게임 참여자 정보가 존재하지 않습니다."));
    }

    private static String extractWords(List<String> players, int pointWidth) {
        String nameFormat = "%" + pointWidth + "s";
        return players.stream()
                .map(name -> String.format(nameFormat, name))
                .collect(Collectors.joining(" "));
    }

    private static String extractLine(Line line, int pointWidth) {
        List<Direction> directions = line.toDirections();

        StringJoiner result = new StringJoiner(VERTICAL, VERTICAL, VERTICAL);
        for (int i = 0; i < directions.size() - 1; i++) {
            Direction direction = directions.get(i);
            String stepPointFormat = toStepPointFormat(direction.getRightStepPoint(), pointWidth);
            result.add(stepPointFormat);
        }
        return toStepPointFormat(StepPoint.NONE, pointWidth) + result;
    }

    private static String toStepPointFormat(StepPoint point, int pointWidth) {
        if (point == StepPoint.EXIST) {
            return STEP_EXIST.repeat(pointWidth);
        }
        return STEP_NONE.repeat(pointWidth);
    }

}
