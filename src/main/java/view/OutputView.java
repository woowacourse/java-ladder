package view;

import static view.LadderFormat.DELIMITER;
import static view.LadderFormat.EXISTED_LINE;
import static view.LadderFormat.NON_EXISTED_LINE;
import static view.LadderFormat.START_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.LadderRow;
import domain.Point;
import domain.ResultTable;
import domain.Reward;
import domain.User;
import utils.StringParser;

public class OutputView {

    public static void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printLadder(List<String> userNames, Ladder ladder, List<String> rewards) {
        printResultMessage();
        printUserNames(userNames);
        printLadderMap(ladder);
        printRewards(rewards);
    }

    private static void printResultMessage() {
        System.out.println("\n사다리 결과\n");
    }

    public static void printUserNames(List<String> userNames) {
        String parsedUserNames = String.join(" ", userNames);
        System.out.println(parsedUserNames);
    }

    public static void printLadderMap(Ladder ladder) {
        List<LadderRow> ladderRows = ladder.getLadderRows();
        List<List<Boolean>> ladderMap = ladderRows.stream()
                .map(OutputView::getRight)
                .collect(Collectors.toList());
        convertByPrintFormat(ladderMap).forEach(System.out::println);
    }

    private static List<Boolean> getRight(LadderRow ladderRow) {
        return ladderRow.getPoints()
                .stream()
                .map(Point::isRight)
                .collect(Collectors.toList());
    }

    private static List<String> convertByPrintFormat(List<List<Boolean>> ladder) {
        return ladder.stream()
                .map(OutputView::formatLadderRow)
                .collect(Collectors.toList());
    }

    private static String formatLadderRow(List<Boolean> ladderRow) {
        List<String> collect = parseLadderRow(ladderRow);
        return START_DELIMITER.getFormat() + String.join(DELIMITER.getFormat(), collect);
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

    private static void printRewards(List<String> rewardNames) {
        List<String> formattedRewardNames = formatLength(rewardNames);
        String parsedUserNames = String.join(" ", formattedRewardNames);
        System.out.println(parsedUserNames);
    }

    private static List<String> formatLength(List<String> rewardNames) {
        return rewardNames.stream()
                .map(StringParser::insertBlank)
                .collect(Collectors.toList());
    }

    public static void printResult(User user, Reward reward) {
        String userName = user.getName();
        String rewardName = reward.getReward();
        System.out.println(userName + " : " + rewardName);
    }

    public static void printAllResult(ResultTable resultTable) {
        List<User> users = resultTable.getUsers();
        for (User user : users) {
            String reward = resultTable.getRewardByUser(user).getReward();
            System.out.println(user.getName() + " : "  + reward);
        }
    }
}
