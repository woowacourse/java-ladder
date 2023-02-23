package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultByPlayerTest {

    @Test
    @DisplayName("참여자별 실행 결과를 생성한다.")
    void generateTest() {
        Map<Player, Result> resultByPlayer = new HashMap<>();
        resultByPlayer.put(new Player( new Name("seong"), new StartIndex(0)), new Result(new Reward("꽝", 0)));
        resultByPlayer.put(new Player( new Name("io"), new StartIndex(1)), new Result(new Reward("5000", 1)));

        Assertions.assertDoesNotThrow(() -> new ResultByPlayer(resultByPlayer));
    }

    @Test
    @DisplayName("주어진 참여자로 해당 참여자의 실행 결과를 반환한다.")
    void findResultByPlayerTest() {
        Map<Player, Result> resultByPlayer = new HashMap<>();
        Player player2 = new Player(new Name("io"), new StartIndex(1));
        Player player1 = new Player(new Name("seong"), new StartIndex(0));

        Result result1 = new Result(new Reward("꽝", 0));
        Result result2 = new Result(new Reward("5000", 1));

        resultByPlayer.put(player1, result1);
        resultByPlayer.put(player2, result2);

        ResultByPlayer generatedResultByPlayer = new ResultByPlayer(resultByPlayer);

        assertThat(generatedResultByPlayer.findResultByPlayer(player1)).isEqualTo(result1);
        assertThat(generatedResultByPlayer.findResultByPlayer(player2)).isEqualTo(result2);
    }

    @Test
    @DisplayName("모든 참여자별 실행결과를 반환한다.")
    void findAllTest() {
        Map<Player, Result> resultByPlayer = new HashMap<>();
        Player player1 = new Player(new Name("seong"), new StartIndex(0));
        Player player2 = new Player(new Name("io"), new StartIndex(1));

        Result result1 = new Result(new Reward("꽝", 0));
        Result result2 = new Result(new Reward("5000", 1));

        resultByPlayer.put(player1, result1);
        resultByPlayer.put(player2, result2);

        ResultByPlayer generatedResultByPlayer = new ResultByPlayer(resultByPlayer);
        Map<Player, Result> allResultByPlayer = generatedResultByPlayer.findAll();

        assertThat(allResultByPlayer.size()).isEqualTo(2);
        assertThat(allResultByPlayer.get(player1)).isEqualTo(result1);
        assertThat(allResultByPlayer.get(player2)).isEqualTo(result2);
    }
}
