package ladder.domain.controller;

import ladder.domain.Ladder;
import ladder.domain.Prizes;
import ladder.domain.Users;
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
        Map<String, String> results = calculateAllResult(users, ladder, prizes);

        readResults(results);

    }

    private void readResults(Map<String, String> results) {
        String userName = inputPrizeWinner();
        while (!userName.equals(COMMAND_ALL)) {
            String prizeName = results.getOrDefault(userName, "없는 유저입니다.");
            printSingleResult(prizeName);
            userName = inputPrizeWinner();
        }
        printAll(results);
    }

    private Map<String, String> calculateAllResult(Users users, Ladder ladder, Prizes prizes) {
        Map<String, String> results = new HashMap<>();
        for (int i = 0; i < users.getSize(); i++) {
            int prizeIndex = ladder.getResult(i);
            results.put(users.getUserNameByIndex(i), prizes.getPrizeNameByIndex(prizeIndex));
        }
        return results;
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
}
