package ladder.view;

import ladder.domain.*;
import ladder.dto.PointsTupleDto;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.List;

public class OutputView {
    private static final int PADDING_WIDTH = 5;
    private static final String NEW_LINE = "\n";

    public static void printRewardErrorMsg() {
        System.out.println("보상은 1자 이상 5자 이내여야 합니다.");
    }

    public static void printLadderMessage() {
        System.out.println("\n사다리 결과\n");
    }

    public static void printNames(final Players players) {
        Iterator<Player> iter = players.iterator();
        while (iter.hasNext()) {
            Player player = iter.next();
            System.out.printf("%s ", StringUtils.center(player.toString(), PADDING_WIDTH));
        }
        System.out.println();
    }

    public static void printLadder(final Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
            System.out.println();
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
        System.out.print(sb.toString());
    }

    private static String printPoint(final Boolean point) {
        if (point) {
            return "-----";
        }
        return "     ";
    }

    public static void printRewards(final Rewards rewards) {
        Iterator<Reward> iter = rewards.iterator();
        while (iter.hasNext()) {
            Reward reward = iter.next();
            System.out.printf("%s ", StringUtils.center(reward.toString(), PADDING_WIDTH));
        }
        System.out.println(NEW_LINE);
    }

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(final String reward) {
        printResultMessage();
        System.out.println(reward);
    }

    public static void printResultAll(final String results) {
        printResultMessage();
        System.out.println(results);
    }

    public static void printResultErrorMsg() {
        System.out.println("존재하는 이름을 입력해야 합니다.");
    }
}