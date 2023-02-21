package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RewardsTest {

    private List<String> names;
    private int playerSize;

    @BeforeEach
    void init() {
        names = List.of("꽝", "5000", "꽝", "3000");
        playerSize = 4;
    }

    @DisplayName("보상의 개수가 참가자 수와 다르다면 예외를 발생시킨다.")
    @ParameterizedTest
    @CsvSource({"2", "3", "5", "6"})
    void throwExceptionWhenRewardsSizeNotEqualToPlayersSize(int playersSize) {
        assertThatThrownBy(() -> new Rewards(names, playersSize))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행 결과의 수는 참여자 수와 동일해야 합니다.");
    }

    @DisplayName("보상의 개수가 참가자 수와 같다면 예외를 발생시키지 않는다.")
    @Test
    void doesNotThrowExceptionWhenRewardsSizeEqualToPlayersSize() {
        assertThatCode(() -> new Rewards(names, playerSize))
                .doesNotThrowAnyException();
    }

    @DisplayName("번호에 맞는 보상을 반환한다.")
    @ParameterizedTest
    @CsvSource({"0,꽝", "1,5000", "2,꽝", "3,3000"})
    void shouldReturnRewardMatchedToIndex(int index, String expected) {
        Rewards rewards = new Rewards(names, playerSize);
        Assertions.assertThat(rewards.getReward(index).getName()).isEqualTo(expected);
    }
}
