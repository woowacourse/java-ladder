package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LineTest {
    @Test
    @DisplayName("연속으로 True를 가질 수 없다.")
    void notConsecutiveDraw() {
        Line line = new Line(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION);

        List<ConnectionStatus> isConnections = line.getConnectionStatuses();

        boolean isConsecutive = false;
        for (int i = 1; i < isConnections.size(); i++) {
            if (isConnections.get(i).equals(ConnectionStatus.CONNECTION) && isConnections.get(i - 1).equals(ConnectionStatus.CONNECTION)) {
                isConsecutive = true;
                break;
            }
        }

        assertFalse(isConsecutive);
    }

    @Test
    @DisplayName("사다리를 내려갈 때 왼쪽은 true, 오른쪽은 false면 왼쪽으로 이동한다.")
    void moveLeft() {
        Line line = new Line(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION);

        assertAll(
                () -> assertThat(line.descend(0)).isEqualTo(1),
                () -> assertThat(line.descend(2)).isEqualTo(3)
        );
    }

    @Test
    @DisplayName("사다리를 내려갈 때 왼쪽은 false, 오른쪽은 true면 오른쪽으로 이동한다.")
    void moveRight() {
        Line line = new Line(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION);

        assertAll(
                () -> assertThat(line.descend(1)).isEqualTo(0),
                () -> assertThat(line.descend(3)).isEqualTo(2)
        );
    }
}
