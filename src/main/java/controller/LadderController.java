package controller;

import domain.ladder.Ladder;
import domain.ladder.LadderMaker;
import domain.ladder.Line;
import domain.player.Player;
import domain.player.Players;
import utils.Log;
import view.InputView;
import view.OutputView;

import java.util.stream.Collectors;

public class LadderController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LadderMaker ladderMaker = new LadderMaker();

    public void run() {
        Players players = getPlayers();
        int personCount = players.getPlayers().size();
        int ladderHeight = getLadderHeight();

        Ladder ladder = new Ladder(ladderMaker.make(personCount, ladderHeight));

        showResult(players, ladder);
    }

    private Players getPlayers() {
        try {
            return new Players(inputView.readNames());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getPlayers();
        }
    }

    private int getLadderHeight() {
        try {
            return inputView.readLadderHeight();
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getLadderHeight();
        }
    }

    private void showResult(Players players, Ladder ladder) {
        outputView.showResultMessage();
        outputView.showPlayers(players.getPlayers());
        outputView.showLadder(ladder);
    }
}
