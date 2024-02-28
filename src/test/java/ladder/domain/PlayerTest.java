package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @DisplayName("사용자 이름, 현재 위치한 라인 번호와 층을 입력하면 인스턴스를 생성한다.")
    @Test
    void 플레이어_인스턴스_생성() {
        // Given
        final String userName = "kelly";
        final int lineNumber = 1;
        final int lineFloor = 5;

        // When
        final Player player = Player.of(userName, lineNumber, lineFloor);

        // Then
        assertThat(player).isNotNull();
    }

    @DisplayName("플레이어가 사다리에서 내려왔다면 true를 반환한다.")
    @Test
    void 플레이어_사다리_내려_오면_true_반환() {
        // Given
        final Player player = Player.of("kelly", 1, 0);

        // When
        final boolean isEscapeLadder = player.escapeLadder();

        // Then
        assertThat(isEscapeLadder).isTrue();
    }

    @DisplayName("플레이어가 이동하면 현재 위치한 층과 라인 번호 정보가 갱신된다.")
    @Test
    void 플레이어_이동() {
        // Given
        final Player player = Player.of("kelly", 2, 5);
        final int moveLineDistance = 1;

        // When
        player.move(moveLineDistance);

        // Then
        assertThat(player.getCurrentLineNumber().value()).isEqualTo(3);
        assertThat(player.getCurrentLineFloor().value()).isEqualTo(4);
    }
}
