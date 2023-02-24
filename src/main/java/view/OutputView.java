package view;

import domain.game.Results;
import domain.info.Name;
import domain.info.Names;
import domain.info.Reward;
import domain.info.Rewards;
import domain.ladder.Floor;
import domain.ladder.Ladder;
import java.util.List;

public class OutputView {
    private static final String PRINT_ALL_COMMEND = "all";

    public static void printLadderBoard(final Names names, final Ladder ladder, final Rewards rewards) {
        System.out.println(Message.OUTPUT_LINES_MESSAGE.message);
        printNames(names);
        printLadder(ladder.getFloors());
        printRewards(rewards.getRewards());
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

    private static void printRewards(final List<Reward> rewards) {
        for (Reward reward : rewards) {
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
        for (Name nameObj : names.getNames()) {
            printOrPass(name, results, nameObj);
        }
    }

    private static void printOrPass(final String name, final Results results, final Name nameObj) {
        if (isPrint(name, nameObj)) {
            System.out.printf(Message.REWARD_MESSAGE_FORMAT.message, nameObj.getName(),
                    results.getReward(nameObj).getReward());
            System.out.println();
        }
    }

    private static boolean isPrint(final String name, final Name nameObj) {
        return name.equals(nameObj.getName()) || name.equals(PRINT_ALL_COMMEND);
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
