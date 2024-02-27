package ladder.controller;

import ladder.domain.Compensation;
import ladder.domain.Ladder;
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

        printGame(people, ladder, compensation);
        printResult(people, ladder, compensation);
    }

    private void printGame(People people, Ladder ladder, Compensation compensation) {
        OutputView.printPeopleName(people);
        OutputView.printLadder(ladder);
        OutputView.printCompensation(compensation);
    }

    private void printResult(People people, Ladder ladder, Compensation compensation) {
        Result result = Result.of(people, ladder, compensation);

        while (ResultView.isRetry()) {
            ResultView.print(InputView.readName(), result);
        }
    }
}
