package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.strategy.AlwaysGenerateBridgeStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TestDataManager;

public class LadderTest {

    @Test
    @DisplayName("게임 참여자 수와 높이에 따라 사다리 생성")
    void createLadderSuccess() {
        int width = 2;
        int heightSize = 4;
        Height height = new Height(heightSize);

        Ladder ladder = Ladder.of(width, height, new AlwaysGenerateBridgeStrategy());

        assertThat(ladder.getLineSize()).isEqualTo(width);
        assertThat(ladder.getHeightSize()).isEqualTo(heightSize);
    }

    @Test
    @DisplayName("사다리의 다리 생성")
    void buildBridgeSuccess() {
        Ladder ladder = TestDataManager.ladderFromHeight(4);
        Point startPoint = ladder.getPoint(0, 1);
        Point endPoint = ladder.getPoint(0, 2);
        ladder.buildBridge(startPoint, endPoint);

        assertThat(startPoint.matchDirection(Direction.RIGHT_DOWN)).isTrue();
        assertThat(endPoint.matchDirection(Direction.LEFT_DOWN)).isTrue();
    }

    @Test
    @DisplayName("이미 다리가 건설 된 지점을 끝 점으로 다리 생성 불가")
    void buildBridgeFail1() {
        Ladder ladder = TestDataManager.ladderFromHeight(4);
        Point startPoint = ladder.getPoint(0, 1);
        Point endPoint = ladder.getPoint(0, 2);
        ladder.buildBridge(startPoint, endPoint);

        Point previousStartPoint = ladder.getPoint(0, 0);
        ladder.buildBridge(previousStartPoint, startPoint);

        assertThat(startPoint.matchDirection(Direction.RIGHT_DOWN)).isTrue();
        assertThat(endPoint.matchDirection(Direction.LEFT_DOWN)).isTrue();
        assertThat(previousStartPoint.matchDirection(Direction.STRAIGHT_DOWN)).isTrue();
    }

    @Test
    @DisplayName("이미 다리가 건설 된 지점을 시작점으로 다리 생성 불가")
    void buildBridgeFail2() {
        Ladder ladder = TestDataManager.ladderFromHeight(4);
        Point startPoint = ladder.getPoint(0, 1);
        Point endPoint = ladder.getPoint(0, 2);
        ladder.buildBridge(startPoint, endPoint);

        Point nextEndPoint = ladder.getPoint(0, 3);
        ladder.buildBridge(endPoint, nextEndPoint);

        assertThat(startPoint.matchDirection(Direction.RIGHT_DOWN)).isTrue();
        assertThat(endPoint.matchDirection(Direction.LEFT_DOWN)).isTrue();
        assertThat(nextEndPoint.matchDirection(Direction.STRAIGHT_DOWN)).isTrue();
    }

}
