package ladder.controller;

import ladder.domain.LadderGame;
import ladder.domain.LadderGame.LadderGameBuilder;
import ladder.view.InputView;
import ladder.view.OutputView;
import ladder.view.Result;
import ladder.view.ResultView;
import ladder.view.enums.Command;

public class LadderGameController {
    public LadderGameController() {
    }

    public void run() {
        LadderGame ladderGame = new LadderGameBuilder()
                .names(InputView.readNames())
                .compensations(InputView.readCompensation())
                .height(InputView.readHeight())
                .build();

        printGame(ladderGame);
        printResult(ladderGame);
    }

    private void printGame(LadderGame ladderGame) {
        OutputView.printPeopleName(ladderGame.getPeople());
        OutputView.printLadder(ladderGame.getLadder());
        OutputView.printCompensation(ladderGame.getCompensation());
    }

    private void printResult(LadderGame ladderGame) {
        Result result = ladderGame.getResult();
        String input;
        while (!Command.STOP.isSameWith(input = InputView.readName())) {
            printResultByInput(input, result);
        }
    }

    private void printResultByInput(String input, Result result) {
        if (Command.PRINT_ALL.isSameWith(input)) {
            ResultView.printAll(result);
            return;
        }

        ResultView.printResultOf(input, result);
    }
}
