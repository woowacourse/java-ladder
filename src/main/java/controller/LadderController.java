package controller;

import domain.LadderMaker;
import domain.Line;
import domain.Player;
import domain.Players;
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
        int ladderHeight = getLadderHeight();
        LadderMaker ladderMaker = new LadderMaker();
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
        List<Player> players = inputView.readNames()
                .stream()
                .map(Player::new)
                .collect(Collectors.toList());
        return new Players(players);
    }
}
