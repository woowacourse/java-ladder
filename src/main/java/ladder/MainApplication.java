package ladder;

import ladder.domain.Ladder;
import ladder.domain.Prizes;
import ladder.domain.Users;
import ladder.domain.generator.RandomPointGenerator;

import java.util.function.Supplier;

import static ladder.view.InputView.*;
import static ladder.view.OutputView.*;

public class MainApplication {

    private static final int INITIAL_HEIGHT_POSITION = 0;
    private static final String COMMAND_PRINT_ALL = "all";

    public static void main(String[] args) {

        Users users = readInput(() -> new Users(inputUserNames()));
        Ladder ladder = readInput(() -> new Ladder(inputFloorHeight(), users, new RandomPointGenerator()));
        Prizes prizes = readInput(() -> new Prizes(inputPrizes(), users));

        printLadder(users, ladder, prizes);

        readResultRequest(users, ladder, prizes);
    }

    private static <T> T readInput(Supplier<T> supplier) {

        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readInput(supplier);
        }
    }

    private static void readResultRequest(Users users, Ladder ladder, Prizes prizes) {

        String userName = inputPrizeWinner();

        if (userName.equals(COMMAND_PRINT_ALL)) {
            printResultPrefix();
            printAll(users, ladder, prizes);
            return;
        }

        for (int i = 0; i < users.getSize(); i++) {
            printResultPrefix();
            printSingleMatchingResult(users, ladder, prizes, userName, i);
        }

        readResultRequest(users, ladder, prizes);
    }

    private static void printAll(Users users, Ladder ladder, Prizes prizes) {
        for (int i = 0; i < users.getSize(); i++) {
            System.out.print(users.getUserNameByIndex(i) + " : ");
            printPrize(ladder, prizes, i);
        }
    }

    private static void printSingleMatchingResult(Users users, Ladder ladder, Prizes prizes, String userName, int index) {

        if (users.getUserNameByIndex(index).equals(userName)) {
            printPrize(ladder, prizes, index);
        }
    }

    private static void printPrize(Ladder ladder, Prizes prizes, int index) {
        int prizeIndex = ladder.getResult(index, INITIAL_HEIGHT_POSITION);
        printResult(prizes, prizeIndex);
    }
}
