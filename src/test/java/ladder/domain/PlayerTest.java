package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    @DisplayName("사용자 이름, 현재 위치한 라인 번호와 층을 입력하면 인스턴스를 생성한다.")
    @Test
    void 플레이어_인스턴스_생성() {
        // Given
        UserName userName = new UserName("kelly");
        LineNumber lineNumber = new LineNumber(1);
        LineFloor lineFloor = new LineFloor(5);

        // When
        Player player = new Player(userName, lineNumber, lineFloor);

        // Then
        assertThat(player).isNotNull();
    }
}
