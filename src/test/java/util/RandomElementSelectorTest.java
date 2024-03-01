package util;

import static domain.Connection.DISCONNECTION;
import static domain.Connection.RIGHT_CONNECTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.Connection;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤 요소 선택 기능 테스트")
class RandomElementSelectorTest {

    @DisplayName("Enum 클래스의 상수 중 랜덤으로 하나를 고를 수 있다")
    @Test
    void testSelectedRandomIsInOriginCollection() {
        Connection randomStatus = RandomElementSelector.selectRandomFrom(RIGHT_CONNECTION, DISCONNECTION);
        assertThat(randomStatus).isIn(List.of(RIGHT_CONNECTION, DISCONNECTION));
    }
}
