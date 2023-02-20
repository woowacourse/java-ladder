package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ladder.Ladder;

import java.security.SecureRandom;
import java.util.List;

import domain.ladder.strategy.GenerateBridgeStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    private static final int PLAYER_COUNT = 4;
    private static final int HEIGHT_SIZE = 5;
    private PlayerNames playerNames;
    private Height height;

    @BeforeEach
    void beforeEach() {
        playerNames = PlayerNames.from(List.of("pobi", "crong", "honux", "jk"));
        height = new Height(HEIGHT_SIZE);
    }

    @Test
    @DisplayName("게임 참여자 수와 높이에 따라 사다리 생성")
    void createLadderSuccess() {
        Ladder ladder = Ladder.of(playerNames, height, new AlwaysGenerateBridgeStrategy());
        int lineCount = ladder.getLines().size();
        int lineHeight = ladder.getHeightSize();

        assertThat(lineCount).isEqualTo(PLAYER_COUNT);
        assertThat(lineHeight).isEqualTo(HEIGHT_SIZE);
    }

    @Test
    @DisplayName("사다리의 다리 생성")
    void buildBridgeSuccess() {
        Ladder ladder = Ladder.of(playerNames, height, new AlwaysGenerateBridgeStrategy());
        Point startPoint = ladder.getPoint(0, 1);
        Point endPoint = ladder.getPoint(0, 2);
        ladder.buildBridge(startPoint, endPoint);

        assertThat(startPoint.matchDirection(Direction.RIGHT_DOWN)).isTrue();
        assertThat(endPoint.matchDirection(Direction.LEFT_DOWN)).isTrue();
    }

    @Test
    @DisplayName("이미 다리가 건설 된 지점을 끝 점으로 다리 생성 불가")
    void buildBridgeFail1() {
        Ladder ladder = Ladder.of(playerNames, height, new AlwaysGenerateBridgeStrategy());
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
        Ladder ladder = Ladder.of(playerNames, height, new AlwaysGenerateBridgeStrategy());
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

class AlwaysGenerateBridgeStrategy implements GenerateBridgeStrategy {

    @Override
    public boolean isGeneratedBridge() {
        return true;
    }

}
