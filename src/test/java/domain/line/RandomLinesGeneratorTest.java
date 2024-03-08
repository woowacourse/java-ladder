package domain.line;

import domain.ConnectionStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("상태가 랜덤한 라인 생성 전략 테스트")
class RandomLinesGeneratorTest {

    private RandomLinesGenerator nonContinuousLineGenerator;

    @BeforeEach
    void setUp() {
        nonContinuousLineGenerator = new RandomLinesGenerator();
    }

    @DisplayName("라인을 생성할 때 이전의 연결상태가 true이면 false를 다음값으로 채택한다")
    @Test
    void testDecideNextConnectionByPrevStatus() {
        ConnectionStatus prev = CONNECTED;
        ConnectionStatus decided = nonContinuousLineGenerator.decideCurrentStatus(prev);
        assertThat(decided).isEqualTo(DISCONNECTED);
    }
}
