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
import validator.dto.InputRepeatableDTO;
import view.InputView;
import view.OutputView;

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
        repeatViewResult(ladderGame);
    }

    private LadderGame initLadderGame() {
        Names inputNames = inputView.inputNames();
        Results inputResult = inputView.inputResults();
        Ladder ladder = makeLadder(inputNames.size());

        outputView.printLadder(inputNames, ladder, inputResult);

        Players players = new PlayerMaker().make(inputNames);
        return new LadderGame(ladder, players, inputResult);
    }

    private Ladder makeLadder(int inputNameSize) {
        Height height = inputView.inputLadderHeight();
        Width width = new Width(inputNameSize - 1);
        return ladderMaker.make(height, width);
    }

    private void repeatViewResult(final LadderGame ladderGame) {
        boolean isRepeat = repeatableViewResult(ladderGame);

        while (isRepeat) {
            isRepeat = repeatableViewResult(ladderGame);
        }
    }

    private boolean repeatableViewResult(LadderGame ladderGame) {
        InputRepeatableDTO inputRepeatableDTO = inputView.inputResultViewersName(ladderGame.allPlayersName());
        if (!inputRepeatableDTO.isRepeatable()) {
            return false;
        }
        Names viewers = inputRepeatableDTO.getNames();
        Results viewResult = ladderGame.resultsByNames(viewers);

        outputView.printGameResult(viewers, viewResult);
        return true;
    }

}
