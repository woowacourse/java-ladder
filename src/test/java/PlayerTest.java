import domain.Player;
import domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @DisplayName("플레이어 객체를 정상적으로 생성한다.")
    @Test
    void createPlayer() {
        assertThat(new Player("dodo", new Position(0)).getName()).isEqualTo("dodo");
    }
}
