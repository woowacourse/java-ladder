package controller;

import domain.Ladder;
import domain.Players;
import domain.RandomStickGenerator;
import domain.StickGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        List<String> names = inputView.readNames();
        int height = inputView.readHeight();
        Players players = new Players(names);
        StickGenerator stickGenerator = new RandomStickGenerator();
        Ladder ladder = new Ladder(height, players.getPlayerSize(), stickGenerator);

        outputView.printLadder(players, ladder);
    }
}
