package ladder;

import ladder.controller.GameController;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

public class GameApplication {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        tryRegistParticipant(gameController);
        tryRegistRewards(gameController);
        tryMakeLadder(gameController);

        OutputView.printLadderResult(gameController.getLadder(), gameController.getParticipants(),gameController.getRewards());
        do {
            tryPrintGameResult(gameController.getGameResult());
        } while (!gameController.getGameEnd());
    }

    private static void tryPrintGameResult(Result gameResult) {
        try{
            OutputView.printGameResult(gameResult);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage()+"\n");
            tryPrintGameResult(gameResult);
        }
    }

    private static void tryRegistParticipant(GameController gameController) {
        try {
            gameController.registParticipant(InputView.inputNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()+"\n");
            tryRegistParticipant(gameController);
        }
    }

    private static void tryRegistRewards(GameController gameController) {
        try {
            gameController.resistRewards(InputView.inputRewards());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()+"\n");
            tryRegistRewards(gameController);
        }
    }

    private static void tryMakeLadder(GameController gameController) {
        try {
            gameController.makeLadder(InputView.inputLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            tryRegistRewards(gameController);
        }
    }


}
