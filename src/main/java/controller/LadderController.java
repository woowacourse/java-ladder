package controller;

import domain.model.Ladder;
import domain.model.Players;
import domain.service.LadderGame;
import domain.service.LadderMaker;
import domain.vo.Results;
import dto.LadderParameter;
import dto.ViewResultParameter;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;

    public LadderController(final InputView inputView,
                            final OutputView outputView,
                            final LadderMaker ladderMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
    }

    public void play() {
        LadderGame ladderGame = initLadderGame();
        ladderGame.play();
        try {
            repeatableViewResult(ladderGame);
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
        }
    }

    private LadderGame initLadderGame() {
        List<String> inputNames = inputView.inputNames();
        List<String> inputResult = inputView.inputResults();

        Ladder ladder = initLadder(inputNames.size());

        outputView.printLadder(inputNames, ladder, inputResult);

        Players players = Players.from(inputNames);
        Results results = Results.from(inputResult);
        return new LadderGame(ladder, players, results);
    }

    private Ladder initLadder(final int size) {
        LadderParameter ladderParameter = inputView.inputLadder(size);
        return ladderMaker.make(ladderParameter.getHeight(), ladderParameter.getWidth());
    }

    private void repeatableViewResult(final LadderGame ladderGame) {
        ViewResultParameter viewResultParameter;
        do {
            List<String> viewers = inputView.inputResultViewersName();
            viewResultParameter = ladderGame.viewersAndResults(viewers);
            outputView.printGameResult(viewResultParameter);
        } while (!viewResultParameter.getViewResult().isEmpty());

    }

}
