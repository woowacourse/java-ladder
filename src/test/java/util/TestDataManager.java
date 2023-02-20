package util;

import domain.Height;
import domain.PlayerNames;
import domain.ladder.Ladder;
import domain.ladder.strategy.AlwaysGenerateBridgeStrategy;

public class TestDataManager {

    /**
     *  4명이 참여하는 사다리를 반환합니다.
     * @return ladder
     */
    public static Ladder ladderFromHeight(int heightSize) {
        String playerNamesInput = "pobi,honux,crong,jk";
        String delimiter = ",";
        PlayerNames playerNames = PlayerNames.of(playerNamesInput, delimiter);
        Height height = new Height(heightSize);

        return Ladder.of(playerNames, height, new AlwaysGenerateBridgeStrategy());
    }
}
