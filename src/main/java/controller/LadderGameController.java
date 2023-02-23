package controller;

import domain.*;
import view.InputView;
import view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class LadderGameController {

    private static final String TARGET_PLAYER_BLANK_ERROR = "[ERROR] 빈 문자열 입니다.";
    private static final String ALL_PLAYER = "all";

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

        showLadder(players, results, ladder);
        showResult(players, results, ladder);
    }

    private void showLadder(Players players, Results results, Ladder ladder) {
        outputView.printPlayersName(players.getPlayersName());
        outputView.printLadder(ladder.getLines());
        outputView.printResults(results.getResults());
    }

    private void showResult(Players players, Results results, Ladder ladder) {
        String targetPlayer = inputView.readTargetPlayer();
        validateTargetPlayerBlank(targetPlayer);

        if (targetPlayer.equals(ALL_PLAYER)) {
            processAllPlayerResult(players, results, ladder);
            return;
        }
        processPlayerResult(players, results, ladder, targetPlayer);
    }

    private void processPlayerResult(Players players, Results results, Ladder ladder, String targetPlayer) {
        players.validateTargetPlayer(targetPlayer);
        int position = players.getTargetPlayerPosition(targetPlayer);
        int lastPosition = ladder.getLastPosition(position);

        outputView.printPlayerResult(results.getResult(lastPosition));
    }

    private void processAllPlayerResult(Players players, Results results, Ladder ladder) {
        List<String> playersResult = new ArrayList<>();

        for (int position = 0; position < players.getSize(); position++) {
            int lastPosition = ladder.getLastPosition(position);

            playersResult.add(results.getResult(lastPosition));
        }
        outputView.printAllPlayerResult(players.getPlayersName(), playersResult);
    }

    private void validateTargetPlayerBlank(String targetPlayer) {
        if (targetPlayer.isBlank()) {
            throw new IllegalArgumentException(TARGET_PLAYER_BLANK_ERROR);
        }
    }
}
