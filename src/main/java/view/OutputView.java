package view;

import domain.Floor;
import domain.Name;
import domain.Names;
import domain.Result;
import domain.Reward;
import java.util.List;

public class OutputView {
    private static final String PRINT_ALL_COMMEND = "all";

    public void printLadderBoard(List<Name> names, List<Floor> floors, List<Reward> rewards) {
        System.out.println(Message.OUTPUT_LINES_MESSAGE.message);
        printNames(names);
        printLadder(floors);
        printRewards(rewards);
    }

    private void printNames(List<Name> names) {
        for (Name name : names) {
            System.out.printf(Message.STRING_FORMAT.message, name.getName());
        }
        System.out.println();
    }

    private void printLadder(List<Floor> floors) {
        floors.forEach(floor -> {
            StringBuilder result = new StringBuilder();
            floor.getPoints()
                    .forEach(point -> result.append(getPointString(point)));
            System.out.println(result);
        });
    }

    private void printRewards(List<Reward> rewards) {
        for (Reward reward : rewards) {
            System.out.printf(Message.STRING_FORMAT.message, reward.getReward());
        }
    }

    private String getPointString(boolean isPoint) {
        if (isPoint) {
            return Message.ROW_LADDER.message;
        }
        return Message.EMPTY_ROW_LADDER.message;
    }

    public void printResult(String name, Names names, Result result) {
        System.out.println();
        System.out.println(Message.OUTPUT_RESULT_MESSAGE.message);
        for (Name nameObj : names.getNames()) {
            printOrPass(name, result, nameObj);
        }
    }

    private void printOrPass(String name, Result result, Name nameObj) {
        if (isPrint(name, nameObj)) {
            System.out.printf(Message.REWARD_MESSAGE_FORMAT.message, nameObj.getName(),
                    result.getReward(nameObj).getReward());
            System.out.println();
        }
    }

    private boolean isPrint(String name, Name nameObj) {
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
