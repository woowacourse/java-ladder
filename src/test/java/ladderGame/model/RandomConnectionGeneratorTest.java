package ladderGame.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomConnectionGeneratorTest {

    @Test
    @DisplayName("참여자의 수보다 한 칸 적게 라인이 생성되어야 한다.")
    void checkLineSize() {
        List<ConnectionStatus> connections = RandomConnectionGenerator.makeConnections(5);

        assertThat(connections.size()).isEqualTo(4);
    }
}