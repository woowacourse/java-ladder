package controller;

import domain.*;
import view.InputView;
import view.OutputView;
import java.util.List;

public class LadderGameController {

    private static final String TARGET_PLAYER_BLANK_ERROR = "[ERROR] 빈 문자열 입니다.";
    private static final int SINGLE_SIZE = 1;
    private static final int SINGLE_PLAYER_INDEX = 0;
    private Command command = Command.CONTINUE;

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomPointGenerator generator;

    public LadderGameController(InputView inputView, OutputView outputView, RandomPointGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        Players players = new Players(inputView.readPlayersName());
        Results results = new Results(players.getSize(), inputView.readResults());
        Ladder ladder = new Ladder(inputView.readLadderHeight(), players.getSize(), generator);

        printLadder(players, results, ladder);
        printResult(players, results, ladder);
    }

    private void printLadder(Players players, Results results, Ladder ladder) {
        outputView.printPlayersName(players.getPlayersName());
        outputView.printLadder(ladder.getLines());
        outputView.printResults(results.getResult());
    }

    private void printResult(Players players, Results results, Ladder ladder) {
        while (command.isContinue()) {
            String targetPlayer = inputView.readTargetPlayer();
            validateTargetPlayerBlank(targetPlayer);

            print(players, getResults(players, results, ladder, targetPlayer));
        }
    }

    private void print(Players players, List<String> finalResults) {
        if (finalResults.size() != SINGLE_SIZE) {
            outputView.printAllPlayerResult(players.getPlayersName(), finalResults);
            command = Command.END;
            return;
        }
        outputView.printPlayerResult(finalResults.get(SINGLE_PLAYER_INDEX));
    }

    private static List<String> getResults(Players players, Results results, Ladder ladder, String targetPlayer) {
        return results.getFinalResults(players.getPlayersName(),
                ladder.getLastPositions(players.getSize()),
                targetPlayer);
    }

    private void validateTargetPlayerBlank(String targetPlayer) {
        if (targetPlayer.isBlank()) {
            throw new IllegalArgumentException(TARGET_PLAYER_BLANK_ERROR);
        }
    }
}
