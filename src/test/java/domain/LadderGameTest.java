package domain;

import domain.LadderTest.TestLadderRowGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.LadderRowGenerator;

public class LadderGameTest {

    private LadderRowGenerator ladderRowGenerator;
    private Ladder ladder;
    private Users users;
    private Rewards rewards;

    @BeforeEach
    void init() {
        ladderRowGenerator = new TestLadderRowGenerator();
        ladder = new Ladder(4, 5, ladderRowGenerator);
        users = new Users(
                List.of(new User("userA"), new User("userB"), new User("userC"), new User("userD")));
        rewards = new Rewards(
                List.of(new Reward("1"), new Reward("2"), new Reward("3"), new Reward("4")), 4);
    }

    @Test
    @DisplayName("LadderGame은 Ladder, Users, Rewards 를 받아 생성된다.")
    void ladderGameTest() {
        Assertions.assertThatCode(() -> new LadderGame(ladder, users, rewards))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("play 메서드는 게임 진행 상태 값을 변경시킨다.")
    void should_changeGameProgressStatus_when_play() {
        LadderGame ladderGame = new LadderGame(ladder, users, rewards);

        ladderGame.play();

        Assertions.assertThat(ladderGame.isInProgress()).isTrue();
    }

    @ParameterizedTest(name = "getLadderGameResultByName 메서드는 이름을 통해 결과를 찾을 수 있다.")
    @CsvSource({"userA,1", "userB,4", "userC,3", "userD,2"})
    void should_findLadderGameResultByName_when_getLadderGameResultByName(String userName, String rewardName) {
        LadderGame ladderGame = new LadderGame(ladder, users, rewards);

        LadderGameResult ladderGameResult = ladderGame.getLadderGameResultByName(userName);
        Reward reward = ladderGameResult.findByUser(new User(userName));

        Assertions.assertThat(reward.getRewardName()).isEqualTo(rewardName);
    }
}
