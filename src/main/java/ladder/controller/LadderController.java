package ladder.controller;

import ladder.domain.*;
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

        resultView.printLadder(players.getNames(), Name.NAME_MAXIMUM_LENGTH, ladder.getLines());
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
            List<String> inputNames = inputView.inputPlayerNames(); //문자인지
            List<Player> inputPlayers = createPlayersByName(inputNames); //이름의 글자수 확인
            return new Players(inputPlayers); //중복이름,이름 개수 확인

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
        while(height == null) {
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
