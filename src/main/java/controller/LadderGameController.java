package controller;

import domain.*;
import util.TrueOrFalseGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final TrueOrFalseGenerator trueOrFalseGenerator;

    private static final int FIRST_INDEX=0;

    public LadderGameController(InputView inputView, OutputView outputView, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.trueOrFalseGenerator = trueOrFalseGenerator;
    }

    public void run() {
        Players players = generatePlayers(inputView.readUserNames());
        Height height = new Height(inputView.readHeight());
        Ladder ladder = generateLadder(players, height);
        outputView.printResult(players.getPlayers(), ladder.getLines(), players.getMaxPlayerNameLength());
    }

    private Players generatePlayers(List<String> playersName) {
        List<Player> players = new ArrayList<>();
        for (String playerName : playersName) {
            players.add(new Player(playerName));
        }
        return new Players(players);
    }

    private Ladder generateLadder(Players players, Height height) {
        List<Line> lines = new ArrayList<>();
        int count = FIRST_INDEX;
        while (height.isSameHeight(count)) {
            Line line = new Line(players.getPlayersCount(), trueOrFalseGenerator);
            lines.add(line);
            count++;
        }
        return new Ladder(Collections.unmodifiableList(lines));
    }
}
