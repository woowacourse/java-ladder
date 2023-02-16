package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Ladder;
import domain.ladder.strategy.AlwaysGenerateBridgeStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("게임 참여자 수와 높이에 따라 사다리 생성")
    void createLadderSuccess() {
        int playerCount = 3;
        int heightSize = 5;
        PlayerNumber playerNumber = new PlayerNumber(playerCount);
        Height height = new Height(heightSize);

        Ladder ladder = Ladder.of(playerNumber, height, new AlwaysGenerateBridgeStrategy());

        assertThat(ladder.getLines())
                .hasSize(playerCount);
        assertThat(ladder.getLines().get(0).getPoints())
                .hasSize(heightSize);
    }

    @Test
    @DisplayName("사다리의 다리 생성")
    void buildBridgeSuccess() {
        int playerCount = 3;
        int heightSize = 4;
        PlayerNumber playerNumber = new PlayerNumber(playerCount);
        Height height = new Height(heightSize);

        Ladder ladder = Ladder.of(playerNumber, height, new AlwaysGenerateBridgeStrategy());
        Point startPoint = ladder.getPoint(0, 1);
        Point endPoint = ladder.getPoint(0, 2);
        ladder.buildBridge(startPoint, endPoint);

        assertThat(startPoint.matchDirection(Direction.RIGHT_DOWN)).isTrue();
        assertThat(endPoint.matchDirection(Direction.LEFT_DOWN)).isTrue();
    }

    @Test
    @DisplayName("사다리의 다리는 중복해서 생성 불가")
    void buildBridgeFail() {
        int playerCount = 4;
        int heightSize = 3;
        PlayerNumber playerNumber = new PlayerNumber(playerCount);
        Height height = new Height(heightSize);

        Ladder ladder = Ladder.of(playerNumber, height, new AlwaysGenerateBridgeStrategy());
        Point startPoint = ladder.getPoint(0, 1);
        Point endPoint = ladder.getPoint(0, 2);
        ladder.buildBridge(startPoint, endPoint);

        Point previousStartPoint = ladder.getPoint(0, 0);
        Point nextEndPoint = ladder.getPoint(0, 3);
        ladder.buildBridge(previousStartPoint, startPoint);
        ladder.buildBridge(endPoint, nextEndPoint);

        assertThat(startPoint.matchDirection(Direction.RIGHT_DOWN)).isTrue();
        assertThat(endPoint.matchDirection(Direction.LEFT_DOWN)).isTrue();
        assertThat(previousStartPoint.matchDirection(Direction.STRAIGHT_DOWN)).isTrue();
        assertThat(nextEndPoint.matchDirection(Direction.STRAIGHT_DOWN)).isTrue();
    }

    @Test
    @DisplayName("사다리의 다리 생성")
    void shuffleLadderSuccess() {
        int playerCount = 3;
        int heightSize = 4;
        PlayerNumber playerNumber = new PlayerNumber(playerCount);
        Height height = new Height(heightSize);

        Ladder ladder = Ladder.of(playerNumber, height, new AlwaysGenerateBridgeStrategy());
        ladder.shuffleLadder();
    }


}
