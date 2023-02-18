package view;

import static utils.constants.LadderFormat.EXISTED_LINE;
import static utils.constants.LadderFormat.NON_EXISTED_LINE;

import domain.Ladder;
import domain.LadderRow;
import domain.Users;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LADDER_DELIMITER = "|";
    private static final String PREFIX_LADDER_DELIMITER = "    " + LADDER_DELIMITER;
    private static final String USER_DELIMITER = " ";

    public static void printErrorMessage(final Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printResultMessage() {
        System.out.println("\n실행결과\n");
    }

    public static void printUserNames(final Users users) {
        String userNames = String.join(USER_DELIMITER, users.getUserNames());
        System.out.println(userNames);
    }

    public static void printLadder(final Ladder ladder) {
        List<String> ladderFormat = getLadderFormat(ladder);
        ladderFormat.forEach(System.out::println);
    }

    private static List<String> getLadderFormat(final Ladder ladder) {
        List<LadderRow> ladderRows = ladder.getLadderRows();
        return ladderRows.stream()
                .map(OutputView::getLadderRowFormat)
                .collect(Collectors.toList());
    }

    private static String getLadderRowFormat(final LadderRow ladderRow) {
        List<Boolean> lines = ladderRow.getLines();
        return linesToLadderRowFormat(lines);
    }

    private static String linesToLadderRowFormat(final List<Boolean> lines) {
        return lines.stream()
                .map(OutputView::lineToLineFormat)
                .collect(Collectors.joining(LADDER_DELIMITER, PREFIX_LADDER_DELIMITER, LADDER_DELIMITER));
    }

    private static String lineToLineFormat(final boolean line) {
        if (line) {
            return EXISTED_LINE.getFormat();
        }
        return NON_EXISTED_LINE.getFormat();
    }
}
