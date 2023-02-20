package controller;

import domain.Ladder;
import domain.Players;
import domain.RandomPointGenerator;
import domain.Results;
import view.InputView;
import view.OutputView;
import java.util.List;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RandomPointGenerator generator;

    public LadderGameController(InputView inputView, OutputView outputView, RandomPointGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        List<String> names = inputView.readPlayersName();
        Players players = new Players(names);
        Results results = new Results(names.size(), inputView.readResults());
        int height = inputView.readLadderHeight();
        Ladder ladder = new Ladder(height, names.size(), generator);

        outputView.printPlayersName(players.getPlayersName());
        outputView.printLadder(ladder.getLines());
    }
}



