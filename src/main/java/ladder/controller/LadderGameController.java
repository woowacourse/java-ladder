package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.ResultCommand;

public class LadderGameController {
    private final InputController inputController;
    private final ResultController resultController;

    public LadderGameController(InputController inputController, ResultController resultController) {
        this.inputController = inputController;
        this.resultController = resultController;
    }

    public void run() {
        try {
            LadderGame ladderGame = inputController.initGame();
            resultController.printLadder(ladderGame);
            runGame(ladderGame);
            repeatResultCommand(ladderGame, inputController.inputResultCommand());
        } catch (IllegalArgumentException e) {
            resultController.printErrorMessage(e.getMessage());
        }

    }

    private void runGame(LadderGame ladderGame) {
        ladderGame.run();
    }

    private void repeatResultCommand(LadderGame ladderGame, ResultCommand resultCommand) {
        executeResultCommand(ladderGame, resultCommand);
        if (!resultCommand.equals(ResultCommand.END)) {
            repeatResultCommand(ladderGame, inputController.inputResultCommand());
        }
    }

    private void executeResultCommand(LadderGame ladderGame, ResultCommand resultCommand) {
        if (resultCommand.equals(ResultCommand.END)) {
            resultController.printEndMessage();
        }
        if (resultCommand.equals(ResultCommand.PLAYER)) {
            resultController.printPrizeNameByPlayerName(ladderGame, resultCommand.getName());
        }
        if (resultCommand.equals(ResultCommand.ALL)) {
            resultController.printGameResult(ladderGame);
        }
    }
}
