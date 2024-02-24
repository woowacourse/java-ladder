package ladderGame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineGeneratorTest {

    @Test
    @DisplayName("라인은 연속적으로 연결될 수 없다.")
    void makeLine() {
        List<ConnectionStatus> isConnections = new LineGenerator(() -> true).makeLine(3);
        assertEquals(isConnections, List.of(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION));
    }
}
