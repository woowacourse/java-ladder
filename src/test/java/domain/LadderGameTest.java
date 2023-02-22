package domain;

import domain.LadderTest.TestLadderRowGenerator;
import java.util.List;
import java.util.Map;
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
                List.of(new Result("1"), new Result("2"), new Result("3"), new Result("4")));
    }

    @Test
    @DisplayName("LadderGame은 Ladder, Users, Results를 받아 생성된다.")
    void ladderGameTest() {
        Assertions.assertThatCode(() -> new LadderGame(ladder, users, results))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이름으로 결과를 찾을 수 있다.")
    void findResultByName() {
        LadderGame ladderGame = new LadderGame(ladder, users, results);
        Result result = results.getResults().get(3);

        Result findedResult = ladderGame.findResultByName("userB");

        Assertions.assertThat(findedResult).isEqualTo(result);
    }
}
