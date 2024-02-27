package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @DisplayName("사다리 객체를 정상적으로 생성한다.")
    @Test
    void createLadder() {
        assertThatCode(() -> Ladder.createLadderWithLines(new RandomLegGenerateStrategy(), new Height(1), 1))
                .doesNotThrowAnyException();
    }

    /*
    pobi  honux crong   jk
    |-----|     |-----|
    꽝    5000  꽝    3000
     */
    @DisplayName("플레이어의 보상을 반환합니다.")
    @Test
    void findPlayerReward() {
        //given
        Ladder ladder = Ladder.createLadderWithLines(new RandomLegGenerateStrategy() {
            @Override
            public boolean generateLeg() {
                return true;
            }
        }, new Height(1), 3);
        Players players = new Players(
                List.of(new Player("pobi"),
                        new Player("honux"),
                        new Player("cron"),
                        new Player("jk")));
        Rewards rewards = new Rewards(
                List.of(new Reward("꽝"),
                        new Reward("5000"),
                        new Reward("꽝"),
                        new Reward("3000")));

        //when

        //then
        assertAll(
                () -> assertThat(ladder.findPlayerReward(players.getPlayerOrderNumber("pobi"), rewards))
                        .isEqualTo("5000"),
                () -> assertThat(ladder.findPlayerReward(players.getPlayerOrderNumber("honux"), rewards))
                        .isEqualTo("꽝"),
                () -> assertThat(ladder.findPlayerReward(players.getPlayerOrderNumber("cron"), rewards))
                        .isEqualTo("3000"),
                () -> assertThat(ladder.findPlayerReward(players.getPlayerOrderNumber("jk"), rewards))
                        .isEqualTo("꽝")
        );
    }
}
