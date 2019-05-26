package ladder.view;

import ladder.domain.*;
import ladder.dto.PointsTupleDto;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;

public class OutputView {
    private static final int PADDING_WIDTH = 5;
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String ALL = "all";

    static void printPlayerErrorMsg(Exception e) {
        System.out.println(e.getMessage() + NEW_LINE);
    }

    static void printRewardErrorMsg(Exception e) {
        System.out.println(e.getMessage());
    }

    static void printHeightFormatErrorMsg() {
        System.out.println("정수만 입력할 수 있습니다.");
    }

    static void printHeightRangeErrorMsg(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printLadder(Players players, Rewards rewards, Ladder ladder) {
        printLadderMessage();
        printNames(players);
        printLadder(ladder);
        printRewards(rewards);
    }

    private static void printLadderMessage() {
        System.out.println(NEW_LINE + "사다리 결과" + NEW_LINE);
    }

    private static void printNames(final Players players) {
        for (Player player : players) {
            System.out.printf("%s ", StringUtils.center(player.toString(), PADDING_WIDTH));
        }
        System.out.println();
    }

    private static void printLadder(final Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(final Line line) {
        List<PointsTupleDto> points = line.makeTupleDto();
        Iterator<PointsTupleDto> iter = new Iterator<PointsTupleDto>() {
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < points.size() - 1;
            }

            @Override
            public PointsTupleDto next() {
                return points.get(count++);
            }
        };
        StringBuilder sb = new StringBuilder();
        sb.append("  |");
        while (iter.hasNext()) {
            sb.append(printPoint(iter.next().getRight()));
            sb.append("|");
        }
        System.out.println(sb.toString());
    }

    private static String printPoint(final Boolean point) {
        if (point) {
            return "-----";
        }
        return "     ";
    }

    private static void printRewards(final Rewards rewards) {
        for (Reward reward : rewards) {
            System.out.printf("%s ", StringUtils.center(reward.toString(), PADDING_WIDTH));
        }
        System.out.println(NEW_LINE);
    }

    public static void printResult(ResultPairs pairs) {
        String name;
        while (!(name = InputView.getName()).toLowerCase().equals(ALL)) {
            checkName(name, pairs);
        }
        printResultAll(pairs);
    }

    private static void checkName(String name, ResultPairs pairs) {
        if (pairs.hasName(name)) {
            printResultPair(pairs.findPlayer(name));
            return;
        }
        printResultErrorMsg();
    }

    private static void printResultPair(final ResultPair pair) {
        printResultMessage();
        System.out.println(pair.getReward() + NEW_LINE);
    }

    private static void printResultMessage() {
        System.out.println("실행 결과");
    }

    private static void printResultErrorMsg() {
        System.out.println("존재하는 이름을 입력해야 합니다.");
    }

    private static void printResultAll(final ResultPairs pairs) {
        printResultMessage();
        System.out.println(pairs.toString());
    }
}