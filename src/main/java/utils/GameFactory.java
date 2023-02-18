package utils;

import domain.Game;
import domain.Ladder;
import domain.Players;

public class GameFactory {

    public static Game make(Ladder ladder, Players players) {
        return new Game(ladder, players);
    }
}
