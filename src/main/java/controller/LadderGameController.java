package controller;

import domain.*;
import view.InputView;
import view.OutputView;
import java.util.List;

public class LadderGameController {

    private static final String TARGET_PLAYER_BLANK_ERROR = "[ERROR] 빈 문자열 입니다.";
    private static final String TARGET_PLAYER_EXIST_ERROR = "[ERROR] 없는 참가자입니다.";
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
        List<String> names = inputView.readPlayersName();
        Players players = new Players(names);
        Results results = new Results(names.size(), inputView.readResults());
        int height = inputView.readLadderHeight();
        Ladder ladder = new Ladder(height, names.size(), generator);

        outputView.printPlayersName(players.getPlayersName());
        outputView.printLadder(ladder.getLines());
        outputView.printResults(results.getResults());

        String targetPlayer = inputView.readTargetPlayer();
        validateTargetPlayerBlank(targetPlayer);
        if (!targetPlayer.equals(ALL_PLAYER)) {
            Player player = getPlayer(players, targetPlayer);
            outputView.printPlayResult(player.calculateResult(ladder, results));
            return;
        }
    }

    private Player getPlayer(Players players, String targetPlayer) {
        validateTargetPlayerExist(players.getPlayersName(), targetPlayer);
        Player player = players.getPlayerByName(targetPlayer);
        return player;
    }

    private void validateTargetPlayerExist(List<String> names, String targetPlayer) {
        if (!names.contains(targetPlayer)) {
            throw new IllegalArgumentException(TARGET_PLAYER_EXIST_ERROR);
        }
    }

    private void validateTargetPlayerBlank(String targetPlayer) {
        if (targetPlayer.isBlank()) {
            throw new IllegalArgumentException(TARGET_PLAYER_BLANK_ERROR);
        }
    }
}



