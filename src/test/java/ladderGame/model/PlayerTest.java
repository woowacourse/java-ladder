package ladderGame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("Line의 연결 여부에 따라 위치를 변경한다.")
    void descendLine() {
        Line line = new Line(ConnectionStatus.CONNECTION, ConnectionStatus.DISCONNECTION, ConnectionStatus.CONNECTION);


        Player player1 = new Player("pobi", 0);
        Player player2 = new Player("crong", 1);

        player1.move(line);
        player2.move(line);

        assertThat(player1.getPosition()).isEqualTo(1);
        assertThat(player2.getPosition()).isEqualTo(0);
    }
}
