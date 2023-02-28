package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        Ladder ladder = Ladder.of(Height.from(5), 3);
        Users users = Users.from(List.of("pobi", "joy", "crong"));
        Rewards rewards = Rewards.of(List.of("꽝", "3000", "2000"), 3);

        ladderGame = LadderGame.of(ladder, users, rewards);
    }

    @DisplayName("인덱스를 통해 실행 결과를 조회한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:꽝", "1:3000", "2:2000"}, delimiter = ':')
    void findUserRewardByIndexTest(int index, String expected) {
        assertEquals(expected, ladderGame.findUserReward(index));
    }


    @DisplayName("사용자명을 통해 실행 결과를 조회한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi:꽝", "joy:3000", "crong:2000"}, delimiter = ':')
    void FindUserRewardTest(String name, String expected) {
        assertEquals(expected, ladderGame.findUserReward(name));
    }
}