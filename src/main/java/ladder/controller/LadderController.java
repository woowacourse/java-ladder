package ladder.controller;

import ladder.domain.Bar;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.LineMaker;
import ladder.domain.Name;
import ladder.domain.Players;
import ladder.domain.RandomGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    private final InputView inputView;
    private final ResultView resultView;
    private final RandomGenerator randomIntegerGenerator;

    public LadderController(InputView inputView, ResultView resultView, RandomGenerator randomIntegerGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomIntegerGenerator = randomIntegerGenerator;
    }

    public void run() {
        Players players = createPlayersUntilNoException();
        Height heightOfLadder = decideHeightOfLadderUntilNoException();

        Ladder ladder = createLadder(players, heightOfLadder);

        resultView.printLadder(players.getNames(), showLadder(ladder), Name.NAME_MAXIMUM_LENGTH);
    }

    private Players createPlayersUntilNoException() {
        Players players = null;

        while (players == null) {
            players = createPlayers();
        }
        return players;
    }

    private Players createPlayers() {
        try {
            List<String> inputNames = inputView.inputPlayerNames();
            return new Players(inputNames);

        } catch (IllegalArgumentException e) {
            resultView.printError(e.getMessage());
            return null;
        }
    }

    private List<List<Boolean>> showLadder(Ladder ladder) {
        List<List<Boolean>> ladderData = new ArrayList<>();

        List<Line> lines = ladder.getLadder();
        for (Line line : lines) {
            List<Boolean> lineData = line.getLine().stream()
                    .map(Bar::getValue)
                    .collect(Collectors.toList());

            ladderData.add(lineData);
        }

        return ladderData;
    }

    private Height decideHeightOfLadderUntilNoException() {
        Height height = null;
        while (height == null) {
            height = decideHeightOfLadder();
        }

        return height;
    }

    private Height decideHeightOfLadder() {
        try {
            int height = inputView.inputHeightOfLadder();
            return new Height(height);

        } catch (IllegalArgumentException e) {
            resultView.printError(e.getMessage());
            return null;
        }
    }

    private Ladder createLadder(Players players, Height height) {
        List<Line> lines = new ArrayList<>();

        for (int idx = 0; idx < height.getHeight(); idx++) {
            List<Bar> bars = LineMaker.generate(players.count(), randomIntegerGenerator);
            lines.add(new Line(bars));
        }

        return new Ladder(lines);
    }
}
