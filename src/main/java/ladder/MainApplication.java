package ladder;

import ladder.domain.Ladder;
import ladder.domain.Prizes;
import ladder.domain.Users;
import ladder.domain.generator.RandomPointGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static ladder.view.InputView.*;
import static ladder.view.OutputView.*;

public class MainApplication {

    private static final int INITIAL_HEIGHT_POSITION = 0;
    private static final String COMMAND_PRINT_ALL = "all";
    private static final String BLANK = "";

    public static void main(String[] args) {

        Users users = readInput(() -> new Users(inputUserNames()));
        Ladder ladder = readInput(() -> new Ladder(inputFloorHeight(), users, new RandomPointGenerator()));
        Prizes prizes = readInput(() -> new Prizes(inputPrizes(), users));

        printLadder(users, ladder, prizes);

        String requestedName = BLANK;
        while (!requestedName.equals(COMMAND_PRINT_ALL)) {
            requestedName = inputPrizeWinner();
            checkCases(users, ladder, prizes, requestedName);
        }
    }

    private static <T> T readInput(Supplier<T> supplier) {

        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void checkCases(Users users, Ladder ladder, Prizes prizes, String userName) {

        if (userName.equals(COMMAND_PRINT_ALL)) {
            Map<String, String> allResult = calculateAll(users, prizes, ladder);
            printAll(allResult);
            return;
        }

        if (!users.contain(userName)) {
            printNoUser();
            return;
        }

        calculateSingleResult(users, ladder, prizes, userName);
    }

    private static Map<String, String> calculateAll(Users users, Prizes prizes, Ladder ladder) {
        Map<String, String> allResult = new HashMap<>();
        for (int i = 0; i < users.getSize(); i++) {
            int prizeIndex = ladder.getResult(i, 0);
            allResult.put(users.getUserNameByIndex(i), prizes.getPrizeNameByIndex(prizeIndex));
        }

        return allResult;
    }

    private static void calculateSingleResult(Users users, Ladder ladder, Prizes prizes, String userName) {
        for (int i = 0; i < users.getSize(); i++) {
            printSingleMatchingResult(users, ladder, prizes, userName, i);
        }
    }

    private static void printSingleMatchingResult(Users users, Ladder ladder, Prizes prizes, String userName, int index) {

        if (users.getUserNameByIndex(index).equals(userName)) {
            printPrize(ladder, prizes, index);
        }
    }

    private static void printPrize(Ladder ladder, Prizes prizes, int index) {
        int prizeIndex = ladder.getResult(index, INITIAL_HEIGHT_POSITION);
        printSingleResult(prizes, prizeIndex);
    }
}
