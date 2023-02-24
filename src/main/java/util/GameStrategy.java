package util;

import model.Ladder;

import java.util.Map;

public interface GameStrategy {
    Map<Integer, Integer> playGame(Ladder ladder);
}
