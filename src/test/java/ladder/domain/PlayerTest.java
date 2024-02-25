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
        Player player = Player.of(userName, lineNumber, lineFloor);

        // Then
        assertThat(player).isNotNull();
    }
}
