package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RewardTest {
    @Test
    @DisplayName("Reward는 상품으로 구성된 객체이다.")
    void Test() {
        assertDoesNotThrow(() -> {
            new Reward(List.of("꽝", "1000", "2000", "꽝"));
        });
    }

    @Test
    @DisplayName("Reward에서 n번째 아이템을 얻을 수 있다.")
    void getPositionOfItemTest() {
        final Reward reward = new Reward(List.of("꽝", "1000", "하이", "2000"));
        assertThat(reward.getRewardOf(2)).isEqualTo("하이");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, 4, 5, 6, 7, 8, 100})
    @DisplayName("Reward의 크기에 벗어난 위치의 item을 얻으려하면 예외가 발생한다")
    void getPositionOfItemExceptionTest(int index) {
        final Reward reward = new Reward(List.of("꽝", "1000", "하이", "2000"));
        assertThatThrownBy(() -> {
            reward.getRewardOf(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("해당 위치의 아이템은 존재하지 않습니다.");
    }
}
