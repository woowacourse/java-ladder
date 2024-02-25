package util;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ConnectionStatus;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("랜덤 요소 선택 기능 테스트")
class RandomElementSelectorTest {

    @DisplayName("Enum 클래스의 상수 중 랜덤으로 하나를 고를 수 있다")
    @RepeatedTest(100)
    void testSelectedRandomIsInOriginCollection() {
        ConnectionStatus randomStatus = RandomElementSelector.selectRandomConstant(ConnectionStatus.class);
        assertThat(randomStatus).isIn(Arrays.asList(ConnectionStatus.values()));
    }
}
