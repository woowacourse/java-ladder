package ladder.controller;

import ladder.domain.GameResult;
import ladder.domain.Ladder;
import ladder.domain.PlayerNames;
import ladder.domain.RandomBasedBarGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    public void run() {
        PlayerNames playerNames = getCorrectPlayerNames();
        GameResult gameResult = getGameResult(playerNames);
    
        Ladder ladder = InputView.repeat(() -> getLadder(playerNames, getCorrectLadderHeight()));
    
        printLadderStructure(playerNames, ladder, gameResult);
        viewResult(playerNames, ladder, gameResult);
    }
    
    private PlayerNames getCorrectPlayerNames() {
        return InputView.repeat(() -> new PlayerNames(InputView.inputPeopleNames()));
    }
    
    private GameResult getGameResult(PlayerNames playerNames) {
        return InputView.repeat(() -> new GameResult(getExecutionResults(), playerNames));
    }
    
    private String getExecutionResults() {
        return InputView.inputExecutionResults();
    }
    
    private Integer getCorrectLadderHeight() {
        return InputView.repeat(InputView::inputLadderHeight);
    }
    
    private Ladder getLadder(PlayerNames playerNames, int ladderHeight) {
        return new Ladder(new RandomBasedBarGenerator(), ladderHeight, playerNames.playerSize());
    }
    
    private void printLadderStructure(PlayerNames playerNames, Ladder ladder, GameResult gameResult) {
        OutputView.printNames(playerNames);
        OutputView.printLadder(ladder, playerNames.getFirstPlayerNameLength());
        OutputView.printExecutionResults(gameResult);
    }
    
    private void viewResult(PlayerNames playerNames, Ladder ladder, GameResult gameResult) {
        String existedPlayer = getExistedPlayer(playerNames);
        List<Integer> movedPositions = getMovedPositions(playerNames, ladder);
    
        if (existedPlayer.equals("all")) {
            OutputView.printAllPlayerResult(playerNames, movedPositions, gameResult);
            return;
        }
        
        OutputView.printOnePlayerResult(getPlayerIndex(playerNames, existedPlayer), movedPositions, gameResult);
        viewResult(playerNames, ladder, gameResult);
    }
    
    private String getExistedPlayer(PlayerNames playerNames) {
        return InputView.repeat(() -> getPlayer(playerNames));
    }
    
    private List<Integer> getMovedPositions(PlayerNames playerNames, Ladder ladder) {
        return ladder.getMovedPositions(playerNames.playerSize());
    }
    
    private String getPlayer(PlayerNames playerNames) {
        String player = InputView.inputPlayerName();
        return playerNames.findByName(player);
    }
    
    private int getPlayerIndex(PlayerNames playerNames, String existedPlayer) {
        return playerNames.getPlayerIndex(existedPlayer);
    }
}
