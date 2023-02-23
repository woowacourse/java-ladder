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
    private Results results;

    @BeforeEach
    void init() {
        ladderRowGenerator = new TestLadderRowGenerator();
        ladder = new Ladder(4, 5, ladderRowGenerator);
        users = new Users(
                List.of(new User("userA"), new User("userB"), new User("userC"), new User("userD")));
        results = new Results(
                List.of(new Result("1"), new Result("2"), new Result("3"), new Result("4")), 4);
    }

    @Test
    @DisplayName("LadderGame은 Ladder, Users, Results를 받아 생성된다.")
    void ladderGameTest() {
        Assertions.assertThatCode(() -> new LadderGame(ladder, users, results))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("play 메서드는 게임 진행 상태 값을 변경시킨다.")
    void should_changeGameProgressStatus_when_play() {
        LadderGame ladderGame = new LadderGame(ladder, users, results);

        ladderGame.play();

        Assertions.assertThat(ladderGame.inProgress()).isTrue();
    }

    @ParameterizedTest(name = "getLadderGameResultByName 메서드는 이름을 통해 결과를 찾을 수 있다.")
    @CsvSource({"userA,1", "userB,4", "userC,3", "userD,2"})
    void should_findLadderGameResultByName_when_getLadderGameResultByName(String userName, String resultName) {
        LadderGame ladderGame = new LadderGame(ladder, users, results);

        LadderGameResult ladderGameResult = ladderGame.getLadderGameResultByName(userName);
        Result result = ladderGameResult.findByUser(new User(userName));

        Assertions.assertThat(result.getResultName()).isEqualTo(resultName);
    }
}
