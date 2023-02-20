package util;

import domain.Height;
import domain.LadderGame;
import domain.PlayerNames;
import domain.Players;
import domain.ResultContents;
import domain.ladder.Ladder;
import domain.ladder.strategy.AlwaysGenerateBridgeStrategy;

public class TestDataManager {

    /**
     *  4명이 참여하는 사다리를 반환합니다.
     * @return ladder
     */
    public static Ladder ladderFromHeight(int heightSize) {
        Height height = new Height(heightSize);

        return Ladder.of(4, height, new AlwaysGenerateBridgeStrategy());
    }

    /**
     *  다음과 같은 사다리 게임을 반환합니다.
     *  pobi   crong  royce
     *    ㅣ-----ㅣ     ㅣ
     *    ㅣ-----ㅣ     ㅣ
     *    ㅣ-----ㅣ     ㅣ
     *    꽝    5000  10000
     * @return ladderGame
     */
    public static LadderGame getLadderGame() {
        PlayerNames playerNames = PlayerNames.of("pobi,crong,royce", ",");
        Players players = Players.from(playerNames);
        ResultContents resultContents = ResultContents.of("꽝,5000,10000", ",");
        Ladder ladder = TestDataManager.ladderFromHeight(3);

        return new LadderGame(ladder, players, resultContents);
    }
}
