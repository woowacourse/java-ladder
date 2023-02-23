package util;

import model.*;

import java.util.Map;

public interface GameStrategy {
    Map<Integer,Integer> playGame(Ladder ladder);
}
