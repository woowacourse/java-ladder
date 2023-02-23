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

        outputView.printPlayersName(players.getPlayersName());
        outputView.printLadder(ladder.getLines());
        outputView.printResults(results.getResults());

        String targetPlayer = inputView.readTargetPlayer();
        validateTargetPlayerBlank(targetPlayer);

        if (!targetPlayer.equals(ALL_PLAYER)) {
            players.validateTargetPlayer(targetPlayer);
            Player player = players.getPlayerByName(targetPlayer);
            outputView.printPlayResult(player.calculateResult(ladder, results));
            return;
        }
        outputView.printAllPlayerResult(players.getPlayersName(), getPlayersResult(players, results, ladder));
    }

    private List<String> getPlayersResult(Players players, Results results, Ladder ladder) {
        List<String> playersResult = new ArrayList<>();

        for (Player player : players.getPlayers()) {
            playersResult.add(player.calculateResult(ladder, results));
        }
        return playersResult;
    }

    private void validateTargetPlayerBlank(String targetPlayer) {
        if (targetPlayer.isBlank()) {
            throw new IllegalArgumentException(TARGET_PLAYER_BLANK_ERROR);
        }
    }
}



