package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class RewardsTest {

    private final int numberOfPlayers = 5;
    private List<String> inputRewards;


    @Test
    @DisplayName("입력받은 보상의 수가 입력한 플레이어의 수와 일치하지 않으면 예외가 발생한다.")
    void validateNumberOfRewardTest() {
        inputRewards = List.of("꽝");

        Assertions.assertThatThrownBy(() -> new Rewards(numberOfPlayers, inputRewards))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보상의 개수는 플레이어 수와 일치해야 합니다.");
    }


    @Test
    @DisplayName("입력 받은 보상 중에 비어있는 경우 예외가 발생한다.-")
    void validateBlankRewardTest() {
        List<String> incorrectRewards = List.of("꽝", "", "5만원", "3만원", "rkd");

        Assertions.assertThatThrownBy(() -> new Rewards(numberOfPlayers, incorrectRewards))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보상을 입력하지 않았습니다.");
    }

}
