package controller;

import ladder.domain.*;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderController {
    private static final int MINIMUM_HEIGHT = 1;

    private final RandomGenerator randomIntegerGenerator = new RandomDataGenerator();

    public void run() {
        Players players = createPlayers();
        Height heightOfLadder = decideHeightOfLadder();

        Ladder ladder = createLadder(players, heightOfLadder);

        ResultView.printLadder(players.getNames(), Name.NAME_MAXIMUM_LENGTH, ladder.getLines());
    }

    private Players createPlayers() {
        try {
            List<String> inputNames = InputView.inputPlayerNames();
            List<Player> players = createPlayersByName(inputNames);

            return new Players(players);
        } catch (IllegalArgumentException e) {
            ResultView.printError(e.getMessage());
            return createPlayers();
        }
    }

    private List<Player> createPlayersByName(List<String> inputNames) {
        return inputNames.stream()
                .map(inputName -> new Player(new Name(inputName)))
                .collect(Collectors.toList());
    }

    private Height decideHeightOfLadder() {
        try {
            int inputMaximumHeight = InputView.inputHeightOfLadder();
            int height = randomIntegerGenerator.generateNumber(MINIMUM_HEIGHT, inputMaximumHeight);

            return new Height(height);
        } catch (IllegalArgumentException e) {
            ResultView.printError(e.getMessage());
            return decideHeightOfLadder();
        }
    }

    private Ladder createLadder(Players players, Height height){
        List<Line> lines = new ArrayList<>();
        for (int idx = 0; idx < height.getHeight(); idx++) {
            List<Bar> bars = LineMaker.generate(players.count(), randomIntegerGenerator);
            lines.add(new Line(bars));
        }
        return new Ladder(lines);
    }
}
