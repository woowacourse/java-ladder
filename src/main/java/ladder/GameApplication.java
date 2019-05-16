package ladder;

import ladder.controller.GameController;
import ladder.view.InputView;
import ladder.view.OutputView;

public class GameApplication {
    public static void main(String[] args){
        GameController gameController = new GameController();
        gameController.registParticipant(InputView.inputNames());
        gameController.resistRewards(InputView.inputRewards());
        gameController.makeLadder(InputView.inputLadderHeight());
        OutputView.printLadderResult(gameController.getLadder(),gameController.getParticipants());
        do{
            OutputView.printGameResult(gameController.getGameResult());
        }while(!gameController.getGameEnd());
    }
}
