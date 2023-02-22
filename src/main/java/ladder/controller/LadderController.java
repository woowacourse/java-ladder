package ladder.controller;

import ladder.domain.GameResult;
import ladder.domain.Ladder;
import ladder.domain.PlayerNames;
import ladder.domain.RandomBasedBarGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    public void run() {
        PlayerNames playerNames = InputView.repeat(() -> new PlayerNames(InputView.inputPeopleNames()));
        String executionResults = InputView.repeat(InputView::inputExecutionResults);
        int ladderHeight = InputView.repeat(InputView::inputLadderHeight);
        
        Ladder ladder = new Ladder(new RandomBasedBarGenerator(), ladderHeight, playerNames.playerSize());
        GameResult gameResult = new GameResult(ladder.getMovedPositions(playerNames.playerSize()), executionResults);
        
        OutputView.printNames(playerNames);
        OutputView.printLadder(ladder, playerNames.getFirstPlayerNameLength());
        OutputView.printExecutionResults(gameResult);
    
        while (true) {
            String player = InputView.inputPlayerName();
            int playerIndex = playerNames.getPlayerIndex(player);
    
            if (player.equals("all")) {
                OutputView.printAllPlayerResult(playerNames, gameResult);
                break;
            }
            
            OutputView.printOnePlayerResult(playerIndex, gameResult);
        }
    }
}
