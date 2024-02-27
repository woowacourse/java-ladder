package ladderGame.controller;

import ladderGame.model.*;
import ladderGame.view.InputView;
import ladderGame.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LadderGameController {
    private final String ALL_RESULT_COMMAND = "all";

    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        LadderGame ladderGame = makeLadderGame();

        String wantName;
        while (!(wantName = inputView.inputResultWantPlayerName()).equals(ALL_RESULT_COMMAND)) {
            resultView.printLadderResult(ladderGame.findLadderGameResult(wantName));
        }

        resultView.printAllLadderResult(ladderGame.findAllLadderGameResults());
    }

    private LadderGame makeLadderGame() {
        Players players = new Players(inputView.inputPlayerNames());
        LadderResults ladderResults = new LadderResults(inputView.inputLadderResults());

        Ladder ladder = makeLadder(players.getPlayerSize());
        resultView.printLadder(players.getPlayers(), ladder.getLines(), ladderResults.getLadderResults());

        return new LadderGame(players, ladderResults, ladder);
    }

    private Ladder makeLadder(int playerCount) {
        LineGenerator lineGenerator = new LineGenerator(new RandomBooleanGenerator());
        List<Line> lines = Stream.generate(() -> new Line(lineGenerator.makeLine(playerCount)))
                .limit(inputView.inputMaxLadderHeight())
                .toList();

        return new Ladder(new ArrayList<>(lines));
    }
}
