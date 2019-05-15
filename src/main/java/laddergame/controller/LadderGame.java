package laddergame.controller;

import laddergame.domain.Player;
import laddergame.domain.PlayerGenerator;
import laddergame.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public void play() {
        getPlayers();

    }

    private List<Player> getPlayers() {
        List<Player> players = null;

        try {
            String input = InputView.askUserNames();
            players = PlayerGenerator.createPlayer(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            getPlayers();
        }

        return players;
    }
}
