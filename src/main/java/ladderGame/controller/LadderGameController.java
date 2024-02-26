package ladderGame.controller;

import ladderGame.model.*;
import ladderGame.view.InputView;
import ladderGame.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderGameController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGameController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        Players players = new Players(inputView.inputPlayerNames());

        LineGenerator lineGenerator = new LineGenerator(new RandomBooleanGenerator());
        List<Line> lines = Stream.generate(() -> new Line(lineGenerator.makeLine(players.getPlayerSize())))
                .limit(inputView.inputMaxLadderHeight())
                .toList();

        Ladder ladder = new Ladder(new ArrayList<>(lines));

        resultView.printLadder(players.getPlayers(), ladder.getLines());
    }
}
