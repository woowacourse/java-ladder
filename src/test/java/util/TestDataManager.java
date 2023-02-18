package util;

import domain.Height;
import domain.PlayerNames;
import domain.ladder.Ladder;
import domain.ladder.strategy.AlwaysGenerateBridgeStrategy;
import java.util.List;

public class TestDataManager {

    /**
     *  4명이 참여하는 사다리를 반환합니다.
     * @return ladder
     */
    public static Ladder ladderFromHeight(int heightSize) {
        PlayerNames playerNames = PlayerNames.from(List.of("pobi", "crong", "honux", "jk"));
        Height height = new Height(heightSize);

        return Ladder.of(playerNames, height, new AlwaysGenerateBridgeStrategy());
    }
}
