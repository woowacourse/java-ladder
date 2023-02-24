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

import java.util.function.Consumer;

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
        repeat(this::viewResult, ladderGame);
    }

    private  void repeat(Consumer<LadderGame> consumer, LadderGame ladderGame) {
        try {
            consumer.accept(ladderGame);
            repeat(this::viewResult, ladderGame);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    private void viewResult(LadderGame ladderGame) {
        Names viewers = inputViewers(ladderGame);
        Results viewResult = ladderGame.resultsByNames(viewers);
        outputView.printGameResult(viewers, viewResult);
    }

    private Names inputViewers(LadderGame ladderGame) {
        Names viewers = inputView.inputResultViewerName();
        if (viewers.contains(inputView.getAllMessage())) {
            viewers = ladderGame.getPlayers().mapToNames();
        }
        return viewers;
    }

    private LadderGame initLadderGame() {
        Names inputNames = inputView.inputNames();
        Results inputResult = inputView.inputResults();
        Ladder ladder = getLadder(inputNames.size());
        outputView.printLadder(inputNames, ladder, inputResult);
        Players players = new PlayerMaker().make(inputNames);
        return new LadderGame(ladder, players, inputResult);
    }

    private Ladder getLadder(int inputNameSize) {
        Height height = inputView.inputLadderHeight();
        Width width = new Width(inputNameSize - 1);
        return ladderMaker.make(height, width);
    }

}
