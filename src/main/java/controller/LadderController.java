package controller;

import domain.model.Ladder;
import domain.model.Players;
import domain.service.LadderGame;
import domain.service.LadderMaker;
import domain.vo.Names;
import domain.vo.Results;
import dto.LadderParameter;
import dto.InputRepeatableDTO;
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
        repeatViewResult(ladderGame);
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

    private void repeatViewResult(final LadderGame ladderGame) {
        boolean isRepeat = repeatableViewResult(ladderGame);

        while (isRepeat) {
            isRepeat = repeatableViewResult(ladderGame);
        }
    }

    private boolean repeatableViewResult(final LadderGame ladderGame) {
        Players allPlayers = ladderGame.getPlayers();
        List<String> allPlayersName = allPlayers.nameToString();
        InputRepeatableDTO inputRepeatableDTO = inputView.inputResultViewersName(allPlayersName);
        if (!inputRepeatableDTO.isRepeatable()) {
            return false;
        }
        List<String> viewers = inputRepeatableDTO.getNames();
        Names viewersName = Names.from(viewers);
        List<String> viewResult = ladderGame.resultsByNames(viewersName).mapToString();

        outputView.printGameResult(viewers, viewResult);
        return true;
    }

}
