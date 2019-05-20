package ladderGameSolo.controller;

import ladderGameSolo.domain.Ladder;

public class LadderGame {
    public static Ladder getLadders(int countOfPeople, int height) {
        return new Ladder(countOfPeople, height);
    }
}
