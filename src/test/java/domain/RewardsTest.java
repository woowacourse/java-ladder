package domain;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardsTest {
    @DisplayName("참가자와 결과로 Rewards 객체 생성 테스트")
    @Test
    void 참가자_및_결과입력으로_Rewards_객체_생성_테스트() {
        Assertions.assertDoesNotThrow(() -> {
            new Rewards(Arrays.asList(new Reward("a"), new Reward("b")), 2);
        });
    }

    @DisplayName("참가자와 결과로 Rewards 객체 생성 실패 테스트")
    @Test
    void 참가자_및_결과입력으로_Rewards_객체_생성_실패_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new Rewards(Arrays.asList(new Reward("a"), new Reward("b")), 1);
                });
    }
}
