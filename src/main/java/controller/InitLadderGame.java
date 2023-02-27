package controller;

import domain.item.Items;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.LadderMaker;
import domain.ladderGame.GameInit;
import domain.player.Players;
import utils.Log;
import view.InputView;

public class InitLadderGame {

    private final InputView inputView;
    private final GameInit gameInit;

    public InitLadderGame(InputView inputView) {
        this.inputView = inputView;

        Players players = inputPlayers();
        int personCount = players.getPlayers().size();
        Items items = inputItems(personCount);
        Ladder ladder = inputLadder(personCount);

        this.gameInit = new GameInit(players, ladder, items);
    }

    private Players inputPlayers() {
        try {
            return new Players(inputView.readNames());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return inputPlayers();
        }
    }

    private Ladder inputLadder(int count) {
        Height ladderHeight = getLadderHeight();
        LadderMaker ladderMaker = new LadderMaker(count, ladderHeight);
        return new Ladder(ladderMaker.getLines());
    }

    private Height getLadderHeight() {
        try {
            return new Height(inputView.readLadderHeight());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return getLadderHeight();
        }
    }

    private Items inputItems(int count) {
        try {
            return new Items(count, inputView.readItems());
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return inputItems(count);
        }
    }

    public GameInit getGameInit() {
        return gameInit;
    }
}
