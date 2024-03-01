package domain;

import static domain.Connection.DISCONNECTION;
import static domain.Connection.LEFT_CONNECTION;
import static domain.Connection.RIGHT_CONNECTION;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("연결이 연속되지 않는 연결 상태 생성 전략 테스트")
class NonContinuousConnectionGeneratorTest {

    private ConnectionGenerator connectionGenerator;

    @BeforeEach
    void setUp() {
        connectionGenerator = new NonContinousConnectionGenerator();
    }

    @DisplayName("이전의 연결상태가 오른쪽이면 왼쪽 연결을 다음값으로 채택한다")
    @Test
    void testDecideNextConnectionByPrevStatus() {
        Connection previousStatus = RIGHT_CONNECTION;
        Connection generated = connectionGenerator.generate(previousStatus);
        assertThat(generated).isEqualTo(LEFT_CONNECTION);
    }

    @DisplayName("마지막 연결이고 이전에 오른쪽으로 연결된 적이 없다면 연결되지 않음을 채택한다")
    @Test
    void testDecideLastConnectionWhenPreviousConnectionIsNotRight() {
        Connection previousStatus = LEFT_CONNECTION;
        Connection generated = connectionGenerator.generateLastConnection(previousStatus);
        assertThat(generated).isEqualTo(DISCONNECTION);
    }

    @DisplayName("마지막 연결이고 이전에 오른쪽으로 연결된 적이 없다면 연결되지 않음을 채택한다")
    @Test
    void testDecideLastConnectionWhenPreviousConnectionIsRight() {
        Connection previousStatus = RIGHT_CONNECTION;
        Connection generated = connectionGenerator.generateLastConnection(previousStatus);
        assertThat(generated).isEqualTo(LEFT_CONNECTION);
    }

}
