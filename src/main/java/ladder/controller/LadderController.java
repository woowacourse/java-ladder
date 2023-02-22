package ladder.controller;

import ladder.domain.GameResult;
import ladder.domain.Ladder;
import ladder.domain.PlayerNames;
import ladder.domain.RandomBasedBarGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    public void run() {
        PlayerNames playerNames = getCorrectPlayerNames();
        String executionResults = getCorrectExecutionResults();
        
        Ladder ladder = InputView.repeat(() -> getLadder(playerNames, getCorrectLadderHeight()));
        GameResult gameResult = getGameResult(playerNames, executionResults, ladder);
    
        printLadderStructure(playerNames, ladder, gameResult);
        viewResult(playerNames, gameResult);
    }
    
    private PlayerNames getCorrectPlayerNames() {
        return InputView.repeat(() -> new PlayerNames(InputView.inputPeopleNames()));
    }
    
    private String getCorrectExecutionResults() {
        return InputView.repeat(InputView::inputExecutionResults);
    }
    
    private Integer getCorrectLadderHeight() {
        return InputView.repeat(InputView::inputLadderHeight);
    }
    
    private Ladder getLadder(PlayerNames playerNames, int ladderHeight) {
        return new Ladder(new RandomBasedBarGenerator(), ladderHeight, playerNames.playerSize());
    }
    
    private GameResult getGameResult(PlayerNames playerNames, String executionResults, Ladder ladder) {
        return new GameResult(ladder.getMovedPositions(playerNames.playerSize()), executionResults);
    }
    
    private void printLadderStructure(PlayerNames playerNames, Ladder ladder, GameResult gameResult) {
        OutputView.printNames(playerNames);
        OutputView.printLadder(ladder, playerNames.getFirstPlayerNameLength());
        OutputView.printExecutionResults(gameResult);
    }
    
    private void viewResult(PlayerNames playerNames, GameResult gameResult) {
        String existedPlayer = getExistedPlayer(playerNames);

        if (existedPlayer.equals("all")) {
            OutputView.printAllPlayerResult(playerNames, gameResult);
            return;
        }
        
        OutputView.printOnePlayerResult(getPlayerIndex(playerNames, existedPlayer), gameResult);
        viewResult(playerNames, gameResult);
    }
    
    private String getExistedPlayer(PlayerNames playerNames) {
        return InputView.repeat(() -> getPlayer(playerNames));
    }
    
    private String getPlayer(PlayerNames playerNames) {
        String player = InputView.inputPlayerName();
        return playerNames.findByName(player);
    }
    
    private int getPlayerIndex(PlayerNames playerNames, String existedPlayer) {
        return playerNames.getPlayerIndex(existedPlayer);
    }
}
