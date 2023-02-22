package ladder.domain;

import ladder.util.TrueGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ResultTest {
    private Names names;
    private Ladder ladder;

    @BeforeEach
    void setup() {
        names = new Names(
                Arrays.asList("AAAA", "BBBB", "CCCC", "DDDD", "EEEE")
        );
        ladder = new Ladder(names.size(), new Height(3), new TrueGenerator());
    }

    @DisplayName("참여자 수와 내기 목록의 수가 같아야 한다.")
    @Test
    void createResultFailTestByDifferentCountOfNamesAndBet() {
        List<String> bets = Arrays.asList("꽝", "꽝", "당첨");

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Result(names, bets));
    }

    @DisplayName("참여자 수와 내기 목록의 수가 같아야 한다.")
    @Test
    void createResultSuccessTestByDifferentCountOfNamesAndBet() {
        List<String> bets = Arrays.asList("꽝", "당첨", "꽝", "꽝", "당첨");

        Assertions.assertDoesNotThrow(() -> new Result(names, bets));
    }

    @DisplayName("주어진 사다리(ladder)를 기반으로 결과의 순서를 바꾼다.")
    @Test
    void performResultSuccessTest() {
        List<String> bets = Arrays.asList("A", "B", "C", "D", "E"); // 초기 내기 목록 입력
        Result result = new Result(names, bets);

        result.perform(ladder); // ladder를 기반으로 내기 목록 위치 변경

        List<String> performedResult = Arrays.asList("B", "A", "D", "C", "E"); // 예상 결과

        for (int i = 0; i < performedResult.size(); i++) {
            Assertions.assertEquals(performedResult.get(i), result.getResult().get(i).getBet());
        }
    }
}
