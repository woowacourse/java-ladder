package controller;

import domain.ladderGame.GameInit;
import domain.ladderGame.GameResult;
import domain.ladderGame.LadderGame;
import utils.Log;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LadderGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        InitLadderGame initLadderGame = new InitLadderGame(inputView);
        GameInit gameInit = initLadderGame.getGameInit();
        showInitResult(gameInit);

        LadderGame ladderGame = new LadderGame(gameInit);
        playGame(ladderGame);
    }

    private void showInitResult(GameInit gameInit) {
        outputView.showInitResult(gameInit);
    }

    private void playGame(LadderGame ladderGame) {
        GameResult gameResult = ladderGame.play();
        showGameResult(gameResult);
    }

    private void showGameResult(GameResult gameResult) {
        List<String> playersName = new ArrayList<>(gameResult.getResults().keySet());
        Set<String> checkedPlayer = new HashSet<>();
        while(!gottenAllResult(checkedPlayer, playersName)) {
            String target = readValidatedTarget(playersName);
            outputView.showTargetResult(target, gameResult);
            checkedPlayer.add(target);
        }
        outputView.showAllResult(gameResult);
    }

    private boolean gottenAllResult(Set<String> checkedPlayer, List<String> playersName) {
        if (checkedPlayer.containsAll(playersName))
            return true;
        if (checkedPlayer.contains("all"))
            return true;
        return false;
    }

    private String readValidatedTarget(List<String> playersName) {
        String target = inputView.readTarget();
        try {
            validateIsPlayer(target, playersName);
            return target;
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return readValidatedTarget(playersName);
        }
    }

    private void validateIsPlayer(String target, List<String> playersName) {
        if(target.equals("all") || playersName.contains(target))
            return;
        throw new IllegalArgumentException("참가자 목록에 없습니다.");
    }
}
