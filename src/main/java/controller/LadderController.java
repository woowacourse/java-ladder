package controller;

import domain.item.Items;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Players;
import utils.Log;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Players players = getPlayers();
        int personCount = players.getPlayers().size();
        Items items = getItems(personCount);
        Height ladderHeight = getLadderHeight();

        Ladder ladder = new Ladder(personCount, ladderHeight);

        showLadderResult(players, ladder, items);
    }

    private Players getPlayers() {
        try {
            return new Players(inputView.readNames());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getPlayers();
        }
    }

    private Items getItems(int count) {
        try {
            return new Items(count, inputView.readItems());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getItems(count);
        }
    }

    private Height getLadderHeight() {
        try {
            return new Height(inputView.readLadderHeight());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getLadderHeight();
        }
    }

    private void showLadderResult(Players players, Ladder ladder, Items items) {
        outputView.showResultMessage();
        outputView.showPlayers(players.getPlayers());
        outputView.showLadder(ladder.getLines());
        outputView.showItems(items.getItems());
    }
}
