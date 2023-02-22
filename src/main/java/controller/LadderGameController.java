package controller;

import java.util.List;

import domain.Ladder;
import domain.Players;
import domain.RandomDigitsGenerator;
import view.InputView;
import view.OutputView;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomDigitsGenerator generator;

    public LadderGameController(InputView inputView, OutputView outputView, RandomDigitsGenerator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

    public void run() {
        Players players = getPlayers();
        Ladder ladder = getLadder(players.getCount() - 1);

        outputView.printPlayerNames(players.getNames());
        outputView.printLadder(ladder.getLines());
    }

    private Players getPlayers() {
        try {
            List<String> names = inputView.readPlayerNames();
            return new Players(names);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getPlayers();
        }
    }

    private Ladder getLadder(int width) {
        try {
            int height = inputView.readLadderHeight();
            return new Ladder(height, width, generator);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getLadder(width);
        }
    }

}



