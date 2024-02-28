package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
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
                List.of(new PlayerName("pobi"),
                        new PlayerName("honux"),
                        new PlayerName("cron"),
                        new PlayerName("jk")));
        Rewards rewards = new Rewards(
                List.of(new Reward("꽝"),
                        new Reward("5000"),
                        new Reward("꽝"),
                        new Reward("3000")));

        //when

        //then
        assertAll(
                () -> assertThat(ladder.findPlayerReward(players.getPlayerNameOrderNumber("pobi"), rewards))
                        .isEqualTo("5000"),
                () -> assertThat(ladder.findPlayerReward(players.getPlayerNameOrderNumber("honux"), rewards))
                        .isEqualTo("꽝"),
                () -> assertThat(ladder.findPlayerReward(players.getPlayerNameOrderNumber("cron"), rewards))
                        .isEqualTo("3000"),
                () -> assertThat(ladder.findPlayerReward(players.getPlayerNameOrderNumber("jk"), rewards))
                        .isEqualTo("꽝")
        );
    }

    /*
    pobi  honux crong   jk
    |-----|     |-----|
    꽝    5000  꽝    3000
     */
    @DisplayName("플레이어들의 전체 보상 결과를 반환합니다.")
    @Test
    void findAllPlayerReward() {
        //given
        Ladder ladder = Ladder.createLadderWithLines(new RandomLegGenerateStrategy() {
            @Override
            public boolean generateLeg() {
                return true;
            }
        }, new Height(1), 3);

        PlayerName pobi = new PlayerName("pobi");
        PlayerName honux = new PlayerName("honux");
        PlayerName cron = new PlayerName("cron");
        PlayerName jk = new PlayerName("jk");

        Reward fail1 = new Reward("꽝");
        Reward success1 = new Reward("5000");
        Reward fail2 = new Reward("꽝");
        Reward success2 = new Reward("3000");

        Players players = new Players(List.of(pobi, honux, cron, jk));
        Rewards rewards = new Rewards(List.of(fail1, success1, fail2, success2));

        //when
        Map<PlayerName, String> actualResult = ladder.findAllPlayerReward(players, rewards);

        //then
        assertAll(
                () -> assertThat(actualResult.get(pobi)).isEqualTo(success1.getReward()),
                () -> assertThat(actualResult.get(honux)).isEqualTo(fail1.getReward()),
                () -> assertThat(actualResult.get(cron)).isEqualTo(success2.getReward()),
                () -> assertThat(actualResult.get(jk)).isEqualTo(fail2.getReward())
        );

    }
}
