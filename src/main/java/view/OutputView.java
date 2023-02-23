package view;

import domain.Ladder;
import domain.LadderGameResult;
import domain.LadderRow;
import domain.Line;
import domain.Result;
import domain.Results;
import domain.User;
import domain.Users;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String LADDER_RESULT_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String LADDER_DELIMITER = "|";
    private static final String PREFIX_LADDER_DELIMITER = "    " + LADDER_DELIMITER;
    private static final String USER_DELIMITER = " ";
    private static final String EXIST_LINE_SYMBOL = "-----";
    private static final String NOT_EXIST_LINE_SYMBOL = "     ";
    private static final String RESULT_FORMAT = "%s : %s" + LINE_SEPARATOR;

    public static void printErrorMessage(final Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printResult(final Users users, final Results results, final Ladder ladder) {
        System.out.println(LADDER_RESULT_MESSAGE);
        printUserNames(users);
        printLadder(ladder);
        printResultNames(results);
    }

    private static void printUserNames(final Users users) {
        String userNames = String.join(USER_DELIMITER, users.getUserNames());
        System.out.println(userNames);
    }


    private static void printLadder(final Ladder ladder) {
        List<String> ladderFormat = getLadderFormat(ladder);
        ladderFormat.forEach(System.out::println);
    }

    private static void printResultNames(final Results results) {
        String resultNames = String.join(USER_DELIMITER, results.getResultNames());
        System.out.println(resultNames);
    }

    private static List<String> getLadderFormat(final Ladder ladder) {
        List<LadderRow> ladderRows = ladder.getLadderRows();
        return ladderRows.stream()
                .map(OutputView::getLadderRowFormat)
                .collect(Collectors.toList());
    }

    private static String getLadderRowFormat(final LadderRow ladderRow) {
        List<Line> lines = ladderRow.getLines();
        return linesToLadderRowFormat(lines);
    }

    private static String linesToLadderRowFormat(final List<Line> lines) {
        return lines.stream()
                .map(OutputView::lineToLineFormat)
                .collect(Collectors.joining(LADDER_DELIMITER, PREFIX_LADDER_DELIMITER, LADDER_DELIMITER));
    }

    private static String lineToLineFormat(final Line line) {
        if (line == Line.EXIST) {
            return EXIST_LINE_SYMBOL;
        }
        return NOT_EXIST_LINE_SYMBOL;
    }

    public static void printLadderGameResult(final LadderGameResult ladderGameResult) {
        System.out.println(RESULT_MESSAGE);
        Map<User, Result> result = ladderGameResult.getLadderGameResult();
        result.entrySet().forEach(OutputView::printResultWithFormat);
    }

    private static void printResultWithFormat(final Map.Entry<User, Result> entry) {
        System.out.printf(RESULT_FORMAT, entry.getKey().getName(), entry.getValue().getResultName());
    }
}
