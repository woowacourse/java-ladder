package controller;

import domain.model.Ladder;
import domain.model.Players;
import domain.service.LadderGame;
import domain.service.LadderMaker;
import domain.service.PlayerMaker;
import domain.vo.Height;
import domain.vo.Names;
import domain.vo.Results;
import domain.vo.Width;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderMaker ladderMaker;

    public LadderController(InputView inputView, OutputView outputView, LadderMaker ladderMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderMaker = ladderMaker;
    }

    public void play() {
        LadderGame ladderGame = initLadderGame();
        ladderGame.play();
        viewResult(ladderGame);
    }

    private void viewResult(LadderGame ladderGame) {
        Names viewers = inputView.inputResultViewerName();
        Results viewResult = ladderGame.resultsByNames(viewers);
        outputView.printGameResult(viewers, viewResult);
    }

    private LadderGame initLadderGame() {
        Names inputNames = inputView.inputNames();
        Results inputResult = inputView.inputResults();

        Height height = inputView.inputLadderHeight();
        Width width = new Width(inputNames.size() - 1);
        Ladder ladder = ladderMaker.make(height, width);
        outputView.printLadder(inputNames, ladder, inputResult);
        Players players = new PlayerMaker().make(inputNames);
        return new LadderGame(ladder, players, inputResult);
    }

}
