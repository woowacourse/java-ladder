package ladder.controller;

import ladder.domain.*;
import ladder.domain.generator.RandomPointGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static ladder.view.InputView.*;
import static ladder.view.OutputView.*;

public class LadderGameController {

    private static final String COMMAND_ALL = "all";

    public LadderGameController() {
    }

    public void run() {
        final Users users = readInput(() -> new Users(inputUserNames()));
        final Ladder ladder = readInput(() -> new Ladder(inputFloorHeight(), users, new RandomPointGenerator()));
        final Prizes prizes = readInput(() -> new Prizes(inputPrizes(), users));

        printLadder(users, ladder, prizes);
        Map<UserName, PrizeName> results = calculateAllResult(users, ladder, prizes);

        readResults(results);
    }

    private <T> T readInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Map<UserName, PrizeName> calculateAllResult(Users users, Ladder ladder, Prizes prizes) {
        Map<UserName, PrizeName> results = new HashMap<>();
        for (int i = 0; i < users.getSize(); i++) {
            int prizeIndex = ladder.getResult(i);
            results.put(users.getUserNameByIndex(i), prizes.getPrizeNameByIndex(prizeIndex));
        }
        return results;
    }

    private void readResults(Map<UserName, PrizeName> results) {
        String userName = inputPrizeWinner();
        while (!userName.equals(COMMAND_ALL)) {
            PrizeName prizeName = results.get(new UserName(userName));
            printSingleResult(prizeName);
            userName = inputPrizeWinner();
        }
        printAll(results);
    }
}
