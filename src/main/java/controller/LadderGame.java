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
        Players players = readPlayers();
        int height = readHeight();

        StickGenerator stickGenerator = new RandomStickGenerator();
        Ladder ladder = makeLadder(height, players.getPlayerSize(), stickGenerator);
        outputView.printLadder(players, ladder);
    }

    private int readHeight() {
        try {
            return inputView.readHeight();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readHeight();
        }
    }

    private Players readPlayers() {
        try {
            List<String> names = inputView.readNames();
            return new Players(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPlayers();
        }
    }

    private Ladder makeLadder(int height, int width, StickGenerator stickGenerator) {
        try {
            return new Ladder(height, width, stickGenerator);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadder(readHeight(), width, stickGenerator);
        }
    }
}
