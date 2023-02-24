package controller;

import domain.ladderGame.GameInit;
import domain.ladderGame.GameResult;
import domain.ladderGame.LadderGame;
import utils.Log;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

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
        ladderGame.play();
        GameResult gameResult = ladderGame.getGameResult();
        showGameResult(gameResult);
    }

    private void showGameResult(GameResult gameResult) {
        List<String> playersName = new ArrayList<>(gameResult.getGameResult().keySet());
        while(!playersName.isEmpty()) {
            String target = readValidatedTarget(playersName);
            outputView.showTargetResult(target, gameResult);
            playersName = afterRemoveTarget(playersName, target);
        }
        outputView.showAllResult(gameResult);
    }

    private List<String> afterRemoveTarget(List<String> playersName, String target) {
        if (target.equals("all"))
            return new ArrayList<>();
        playersName.remove(target);
        return playersName;
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
