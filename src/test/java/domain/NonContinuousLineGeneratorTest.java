package domain;

import static domain.ConnectionStatus.CONNECTED;
import static domain.ConnectionStatus.DISCONNECTED;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("연결이 연속되지 않는 라인 생성 전략 테스트")
class NonContinuousLineGeneratorTest {
    private NonContinuousLineGenerator nonContinuousLineGenerator;

    @BeforeEach
    void setUp() {
        nonContinuousLineGenerator = new NonContinuousLineGenerator();
    }

    @DisplayName("라인을 생성할 때 이전의 연결상태가 true이면 false를 다음값으로 채택한다")
    @RepeatedTest(50)
    void testDecideNextConnectionByPrevStatus() {
        ConnectionStatus prev = CONNECTED;
        ConnectionStatus decided = nonContinuousLineGenerator.decideCurrentStatus(prev);
        assertThat(decided).isEqualTo(DISCONNECTED);
    }
}
