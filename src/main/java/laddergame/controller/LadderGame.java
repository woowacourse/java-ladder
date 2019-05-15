package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.Player;
import laddergame.domain.PlayersGenerator;
import laddergame.view.InputView;

import java.util.InputMismatchException;
import java.util.List;

public class LadderGame {
    public void play() {
        List<Player> players = getPlayers();
        Ladder ladder = getLadder(players.size());

    }

    private static List<Player> getPlayers() {
        List<Player> players = null;

        try {
            String input = InputView.askUserNames();
            players = PlayersGenerator.createPlayers(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            getPlayers();
        }

        return players;
    }

    private static Ladder getLadder(int width) {
        try {
            int height = InputView.askHeight();
            return new Ladder(width, height);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getLadder(width);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            return getLadder(width);
        }
    }
}
