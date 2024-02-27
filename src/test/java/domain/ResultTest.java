package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.CustomGenerator;

import java.util.List;

public class ResultTest {
    @DisplayName("입력받은 이름에 맞는 사다리 타기 결과를 반환한다.")
    @Test
    void getResultByPersonTest() {
        List<String> names = List.of("1", "2");
        CustomGenerator customGenerator = new CustomGenerator(List.of(false, true));
        Winnings winnings = new Winnings(List.of("꽝", "당첨"));
        LadderGame ladderGame = new LadderGame(names, new Height(1), winnings, customGenerator);
        Result result = new Result(ladderGame.getResult());
        Assertions.assertThat(result.getResultByPerson("1"))
                .isEqualTo("당첨");
    }
}
