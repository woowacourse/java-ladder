package domain;

import static domain.BridgeIndex.MAXIMUM_INDEX;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeIndexTest {

    @DisplayName("최대 플레이어 수 - 2인 수로 다리 인덱스를 생성하면 에러가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {0, Players.MAXIMUM_PLAYER_SIZE - 2})
    public void createSuccessInRage(int index) {
        assertThatCode(() -> new BridgeIndex(index))
                .doesNotThrowAnyException();
    }

    @DisplayName("최대 플레이어 수 - 2보다 큰 수로 다리 인덱스를 생성하면 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {Players.MAXIMUM_PLAYER_SIZE - 1, 100})
    public void createFailInRage(int index) {
        assertThatCode(() -> new BridgeIndex(index))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("최대 다리 인덱스 %d 보다 큰 수로 생성할 수 없습니다. 입력값: %d", MAXIMUM_INDEX, index));
    }
}
