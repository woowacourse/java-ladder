package ladder.controller;

import ladder.domain.Compensation;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.People;
import ladder.service.LadderGameService;
import ladder.view.InputView;
import ladder.view.OutputView;
import ladder.view.Result;
import ladder.view.ResultView;

import static ladder.utils.InputUtility.retryWhileThrowArgumentException;

public class LadderGameController {
    private final LadderGameService gameService;

    public LadderGameController(LadderGameService gameService) {
        this.gameService = gameService;
    }

    public void run() {
        People people = retryWhileThrowArgumentException(() ->
                gameService.getPeople(InputView.readNames()));
        Compensation compensation = retryWhileThrowArgumentException(() ->
                gameService.getCompensation(InputView.readCompensation(), people));
        Ladder ladder = retryWhileThrowArgumentException(() ->
                gameService.getLadder(InputView.readHeight(), people));

        LadderGame ladderGame = new LadderGame(people, ladder, compensation);
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

        while (ResultView.isRetry()) {
            ResultView.print(InputView.readName(), result);
        }
    }
}
