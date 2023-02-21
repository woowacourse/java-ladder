package view;

import static view.LadderFormat.DELIMITER;
import static view.LadderFormat.EXISTED_LINE;
import static view.LadderFormat.NON_EXISTED_LINE;
import static view.LadderFormat.START_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;

import utils.StringParser;

public class OutputView {

    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printResultMessage() {
        System.out.println("\n사다리 결과\n");
    }

    public static void printUserNames(List<String> userNames) {
        String parsedUserNames = String.join(" ", userNames);
        System.out.println(parsedUserNames);
    }

    public static void printLadder(List<List<Boolean>> ladder) {
        getCollect(ladder)
                .forEach(System.out::println);
    }

    private static List<String> getCollect(List<List<Boolean>> ladder) {
        return ladder.stream()
                .map(OutputView::formatLadderRow)
                .collect(Collectors.toList());
    }

    private static String formatLadderRow(List<Boolean> ladderRow) {
        List<String> collect = parseLadderRow(ladderRow);
        return START_DELIMITER.getFormat() + String.join(DELIMITER.getFormat(), collect) + DELIMITER.getFormat();
    }

    private static List<String> parseLadderRow(List<Boolean> ladderRow) {
        return ladderRow.stream()
                .map(OutputView::parseBar)
                .collect(Collectors.toList());
    }

    private static String parseBar(boolean bar) {
        if (bar) {
            return EXISTED_LINE.getFormat();
        }
        return NON_EXISTED_LINE.getFormat();
    }

    public static void printRewards(List<String> rewardNames) {
        List<String> formattedRewardNames = formatLength(rewardNames);
        String parsedUserNames = String.join(" ", formattedRewardNames);
        System.out.println(parsedUserNames);
    }

    private static List<String> formatLength(List<String> rewardNames) {
        return rewardNames.stream()
                .map(StringParser::insertBlank)
                .collect(Collectors.toList());
    }
}
