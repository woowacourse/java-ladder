package domain;

import static org.assertj.core.api.Assertions.assertThat;

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

        Ladder ladder = Ladder.of(playerNumber, height);

        assertThat(ladder.getLines())
                .hasSize(playerCount);
        assertThat(ladder.getLines().get(0).getPoints())
                .hasSize(heightSize);
    }

    @Test
    @DisplayName("사다리의 다리 생성")
    void createHorizontalLineAtSuccess() {
        int playerCount = 3;
        int heightSize = 4;
        PlayerNumber playerNumber = new PlayerNumber(playerCount);
        Height height = new Height(heightSize);

        Ladder ladder = Ladder.of(playerNumber, height);
        ladder.buildBridge(0, 1);

        ladder.getPoint(0, 1).matchDirection(Direction.RIGHT_DOWN);
        ladder.getPoint(0, 2).matchDirection(Direction.LEFT_DOWN);
    }

    @Test
    @DisplayName("사다리의 다리는 중복해서 생성 불가")
    void createHorizontalLineAtFail() {
        int playerCount = 4;
        int heightSize = 3;
        PlayerNumber playerNumber = new PlayerNumber(playerCount);
        Height height = new Height(heightSize);

        Ladder ladder = Ladder.of(playerNumber, height);
        ladder.buildBridge(0, 1);

        ladder.buildBridge(0, 0);
        ladder.buildBridge(0, 2);

        ladder.getPoint(0, 0).matchDirection(Direction.STRAIGHT_DOWN);
        ladder.getPoint(0, 1).matchDirection(Direction.RIGHT_DOWN);
        ladder.getPoint(0, 2).matchDirection(Direction.LEFT_DOWN);
        ladder.getPoint(0, 3).matchDirection(Direction.STRAIGHT_DOWN);
    }

    @Test
    @DisplayName("사다리의 다리 생성")
    void shuffleLadderSuccess() {
        int playerCount = 3;
        int heightSize = 4;
        PlayerNumber playerNumber = new PlayerNumber(playerCount);
        Height height = new Height(heightSize);

        Ladder ladder = Ladder.of(playerNumber, height);
        ladder.shuffleLadder();
    }


}
