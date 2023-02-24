package ladder.controller;

import ladder.domain.GameResults;
import ladder.domain.Ladder;
import ladder.domain.PlayerNames;
import ladder.domain.RandomBasedBarGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    public void run() {
        PlayerNames playerNames = getCorrectPlayerNames();
        GameResults gameResults = getGameResult(playerNames);
    
        Ladder ladder = getLadder(playerNames);
    
        printLadderStructure(playerNames, ladder, gameResults);
        viewResult(playerNames, ladder, gameResults);
    }
    
    private PlayerNames getCorrectPlayerNames() {
        return InputView.repeat(() -> new PlayerNames(InputView.inputPeopleNames()));
    }
    
    private GameResults getGameResult(PlayerNames playerNames) {
        return InputView.repeat(() -> new GameResults(getExecutionResults(), playerNames));
    }
    
    private String getExecutionResults() {
        return InputView.inputExecutionResults();
    }
    
    private Ladder getLadder(PlayerNames playerNames) {
        return InputView.repeat(() -> getLadder(playerNames, getCorrectLadderHeight()));
    }
    
    private Integer getCorrectLadderHeight() {
        return InputView.repeat(InputView::inputLadderHeight);
    }
    
    private Ladder getLadder(PlayerNames playerNames, int ladderHeight) {
        return new Ladder(new RandomBasedBarGenerator(), ladderHeight, playerNames.playerSize());
    }
    
    private void printLadderStructure(PlayerNames playerNames, Ladder ladder, GameResults gameResults) {
        OutputView.printNames(playerNames);
        OutputView.printLadder(ladder, playerNames.getFirstPlayerNameLength());
        OutputView.printExecutionResults(gameResults);
    }
    
    private void viewResult(PlayerNames playerNames, Ladder ladder, GameResults gameResults) {
        String existedPlayer = getExistedPlayer(playerNames);
        List<Integer> movedPositions = getMovedPositions(playerNames, ladder);
    
        if ("all".equals(existedPlayer)) {
            OutputView.printAllPlayerResult(playerNames, movedPositions, gameResults);
            return;
        }
        
        OutputView.printOnePlayerResult(getPlayerIndex(playerNames, existedPlayer), movedPositions, gameResults);
        viewResult(playerNames, ladder, gameResults);
    }
    
    private String getExistedPlayer(PlayerNames playerNames) {
        return InputView.repeat(() -> getPlayer(playerNames));
    }
    
    private String getPlayer(PlayerNames playerNames) {
        String player = InputView.inputPlayerName();
        return playerNames.findByName(player);
    }
    
    private List<Integer> getMovedPositions(PlayerNames playerNames, Ladder ladder) {
        return ladder.getMovedPositions(playerNames.playerSize());
    }
    
    private int getPlayerIndex(PlayerNames playerNames, String existedPlayer) {
        return playerNames.getPlayerIndex(existedPlayer);
    }
}
