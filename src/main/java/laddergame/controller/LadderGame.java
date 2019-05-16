package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.Player;
import laddergame.domain.PlayersGenerator;
import laddergame.domain.Prize;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.InputMismatchException;
import java.util.List;

public class LadderGame {
    public void play() {
        List<Player> players = getPlayers();
        Ladder ladder = getLadder(players.size());

        OutputView.printLadder(players, ladder);


    }

    private static List<Player> getPlayers() {
        try {
            String input = InputView.askUserNames();
            return PlayersGenerator.createPlayers(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getPlayers();
        }
    }

    private static Ladder getLadder(int width) {
        try {
            int height = InputView.askHeight();
            return new Ladder(width, height);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return getLadder(width);
        }
    }
}
