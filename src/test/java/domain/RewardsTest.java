package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RewardsTest {

    @Test
    @DisplayName("Rewards 생성 실패: null")
    void test_exception_null() {
        assertThatThrownBy(() -> Rewards.from(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("null을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("성공: 인덱스로 Reward의 이름을 찾을 수 있다.")
    void findRewardNameByIndex() {
        Rewards rewards = Rewards.from(List.of("꽝", "10", "20"));
        Assertions.assertAll(
            () -> assertThat(rewards.findRewardNameByIndex(0)).isEqualTo("꽝"),
            () -> assertThat(rewards.findRewardNameByIndex(1)).isEqualTo("10"),
            () -> assertThat(rewards.findRewardNameByIndex(2)).isEqualTo("20")
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("실패: 인덱스가 넘어가는 경우 에러 처리한다.")
    void findRewardNameByIndex_exception(int index) {
        Rewards rewards = Rewards.from(List.of("꽝", "10", "20"));
        assertThatThrownBy(() -> rewards.findRewardNameByIndex(index))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바르지 않은 상품 인덱스입니다.");
    }
}
