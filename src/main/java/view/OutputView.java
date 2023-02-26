package view;

import domain.game.Results;
import domain.info.Info;
import domain.info.Name;
import domain.info.Names;
import domain.info.Reward;
import domain.info.Rewards;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import java.util.List;

public class OutputView {
    private static final String PRINT_ALL_COMMEND = "all";

    public static void printLadderBoard(final Info info, final Ladder ladder) {
        System.out.println(Message.OUTPUT_LINES_MESSAGE.message);
        printNames(info.getNames());
        printLadder(ladder.getFloors());
        printRewards(info.getRewards());
    }

    private static void printNames(final Names names) {
        for (Name name : names.getNames()) {
            System.out.printf(Message.STRING_FORMAT.message, name.getName());
        }
        System.out.println();
    }

    private static void printLadder(final List<Floor> floors) {
        floors.forEach(floor -> {
            StringBuilder result = new StringBuilder();
            floor.getPoints()
                    .forEach(point -> result.append(getPointString(point)));
            System.out.println(Message.COLUMN_LADDER.message + result);
        });
    }

    private static void printRewards(final Rewards rewards) {
        for (Reward reward : rewards.getRewards()) {
            System.out.printf(Message.STRING_FORMAT.message, reward.getReward());
        }
        System.out.println();
    }

    private static String getPointString(final boolean isPoint) {
        if (isPoint) {
            return Message.ROW_LADDER.message;
        }
        return Message.EMPTY_ROW_LADDER.message;
    }

    public static void printResult(final String name, final Names names, final Results results) {
        System.out.println(Message.OUTPUT_RESULT_MESSAGE.message);
        for (Name player : names.getNames()) {
            printOrPass(name, results, player);
        }
    }

    private static void printOrPass(final String name, final Results results, final Name player) {
        if (isPrint(name, player)) {
            System.out.printf(
                    Message.REWARD_MESSAGE_FORMAT.message,
                    player.getName(),
                    results.getReward(player).getReward()
            );
            System.out.println();
        }
    }

    private static boolean isPrint(final String name, final Name player) {
        return name.equals(player.getName()) || name.equals(PRINT_ALL_COMMEND);
    }

    private enum Message {
        OUTPUT_LINES_MESSAGE("사다리 결과"),
        OUTPUT_RESULT_MESSAGE("실행 결과"),
        STRING_FORMAT("%-6s"),
        COLUMN_LADDER("  |"),
        ROW_LADDER("-----|"),
        EMPTY_ROW_LADDER("     |"),
        REWARD_MESSAGE_FORMAT("%s : %s");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
