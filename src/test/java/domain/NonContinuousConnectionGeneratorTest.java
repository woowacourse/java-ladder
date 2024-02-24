package domain;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("연결이 연속되지 않는 연결 상태 생성 전략 테스트")
class NonContinuousConnectionGeneratorTest {

    private ConnectionGenerator connectionGenerator;

    @BeforeEach
    void setUp() {
        connectionGenerator = new NonContinuousConnectionGenerator();
    }

    @DisplayName("이전의 연결상태가 true이면 false를 다음값으로 채택한다")
    @Test
    void testDecideNextConnectionByPrevStatus() {
        ConnectionStatus previousStatus = CONNECTED;
        ConnectionStatus generated = connectionGenerator.generateByPreviousStatus(previousStatus);
        assertThat(generated).isEqualTo(DISCONNECTED);
    }
}
