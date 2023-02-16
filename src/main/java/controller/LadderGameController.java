package controller;

import domain.Height;
import domain.Ladder;
import domain.Line;
import domain.Players;
import util.TrueOrFalseGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final TrueOrFalseGenerator trueOrFalseGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, TrueOrFalseGenerator trueOrFalseGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.trueOrFalseGenerator = trueOrFalseGenerator;
    }

    public void run() {
        Players players = new Players(inputView.readUserNames());
        Height height = new Height(inputView.readHeight());
        Ladder ladder = generateLadder(players, height);
        outputView.printResult(players.getPlayers(), ladder.getLines(), players.getMaxPlayerNameLength());
    }

    private Ladder generateLadder(Players players, Height height) {
        List<Line> lines = new ArrayList<>();
        while (height.isPossibleCount()) {
            Line line = new Line(players.getPlayersCount(), trueOrFalseGenerator);
            lines.add(line);
            height.minusHeight();
        }
        return new Ladder(lines);
    }
}
