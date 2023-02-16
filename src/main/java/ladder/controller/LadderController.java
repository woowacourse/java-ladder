package ladder.controller;

import ladder.domain.Bar;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.LineMaker;
import ladder.domain.Name;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.RandomGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    private static final int MINIMUM_HEIGHT = 1;

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
            List<Player> inputPlayers = createPlayersByName(inputNames);
            return new Players(inputPlayers);

        } catch (IllegalArgumentException e) {
            resultView.printError(e.getMessage());
            return null;
        }
    }

    private List<Player> createPlayersByName(List<String> inputNames) {
        return inputNames.stream()
                .map(inputName -> new Player(new Name(inputName)))
                .collect(Collectors.toList());
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
            int inputMaximumHeight = inputView.inputHeightOfLadder();
            int height = randomIntegerGenerator.generateNumber(MINIMUM_HEIGHT, inputMaximumHeight);

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
