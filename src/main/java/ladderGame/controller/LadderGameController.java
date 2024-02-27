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
        Players players = new Players(inputView.inputPlayerNames());
        LadderResults ladderResults = new LadderResults(inputView.inputLadderResults());

        LineGenerator lineGenerator = new LineGenerator(new RandomBooleanGenerator());
        List<Line> lines = Stream.generate(() -> new Line(lineGenerator.makeLine(players.getPlayerSize())))
                .limit(inputView.inputMaxLadderHeight())
                .toList();

        Ladder ladder = new Ladder(new ArrayList<>(lines));
        resultView.printLadder(players.getPlayers(), ladder.getLines(), ladderResults.getLadderResults());

        LadderGame ladderGame = new LadderGame(players, ladderResults, ladder);

        while(true) {
            String inputName = inputView.inputResultWantPlayerName();
            if(inputName.equals(ALL_RESULT_COMMAND)) {
                List<LadderResult> results = ladderGame.findAllLadderGameResults();
                resultView.printAllLadderResult(players.getPlayers(), results);
                continue;
            }
            resultView.printLadderResult(ladderGame.findLadderGameResult(inputName));
        }
    }
}
