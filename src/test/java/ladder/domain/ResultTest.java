package ladder.domain;

import ladder.util.TrueGenerator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ResultTest {
    private Names names;
    private List<String> bets;

    @BeforeAll
    void setup() {
        names = new Names(
                Arrays.asList("AAAA", "BBBB", "CCCC", "DDDD", "EEEE")
        );
        bets = Arrays.asList("A", "B", "C", "D", "E");
    }

    @DisplayName("참여자 수와 내기 목록의 수가 같아야 한다.")
    @Test
    void createResultFailTestByDifferentCountOfNamesAndBet() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Result(names, Arrays.asList("꽝", "꽝", "당첨")));
    }

    @DisplayName("참여자 수와 내기 목록의 수가 같아야 한다.")
    @Test
    void createResultSuccessTestByCountOfNamesAndBet() {
        Assertions.assertDoesNotThrow(() -> new Result(names, bets));
    }

    @ParameterizedTest(name = "주어진 사다리(ladder)를 기반으로 결과의 순서를 바꾼다.")
    @ValueSource(ints = {1, 3, 5, 7, 9, 11, 13})
    void performResultSuccessTest1(int height) {
        Ladder ladder = new Ladder(names.size(), new Height(height), new TrueGenerator());
        Result result = new Result(names, bets);

        result.perform(ladder); // ladder를 기반으로 내기 목록 위치 변경

        List<String> performedResult = Arrays.asList("B", "A", "D", "C", "E"); // 예상 결과

        for (int i = 0; i < performedResult.size(); i++) {
            Assertions.assertEquals(performedResult.get(i), result.getResult().get(i).toString());
        }
    }

    @ParameterizedTest(name = "주어진 사다리(ladder)를 기반으로 결과의 순서를 바꾼다.")
    @ValueSource(ints = {2, 4, 6, 8, 10, 12, 14})
    void performResultSuccessTest2(int height) {
        Ladder ladder = new Ladder(names.size(), new Height(height), new TrueGenerator());
        Result result = new Result(names, bets);

        result.perform(ladder); // ladder를 기반으로 내기 목록 위치 변경

        List<String> performedResult = Arrays.asList("A", "B", "C", "D", "E"); // 예상 결과

        for (int i = 0; i < performedResult.size(); i++) {
            Assertions.assertEquals(performedResult.get(i), result.getResult().get(i).toString());
        }
    }
}
