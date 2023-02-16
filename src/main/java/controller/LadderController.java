package controller;

import domain.ladder.LadderMaker;
import domain.ladder.Line;
import domain.player.Player;
import domain.player.Players;
import utils.Log;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class LadderController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Players players = getPlayers();
        LadderMaker ladderMaker = new LadderMaker();
        int ladderHeight = getLadderHeight();

        List<Line> lines = ladderMaker.make(players.getPlayers().size(), ladderHeight);
        outputView.showResultMessage();
        outputView.showPlayers(players.getPlayers());
        outputView.showLadder(lines);
    }

    public Players getPlayers() {
        try {
            return createPlayers();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getPlayers();
        }
    }

    public int getLadderHeight() {
        try {
            return inputView.readLadderHeight();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getLadderHeight();
        }
    }

    private Players createPlayers() {
        return new Players(inputView.readNames()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList()));
    }
}
