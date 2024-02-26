package domain.ladderTest;

import domain.Height;
import domain.Ladder;
import domain.Name;
import domain.Names;
import domain.Prizes;
import domain.Result;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderTravelTest {

    private static final Height DEFAULT_HEIGHT = new Height(4);
    private static final Names names = new Names(List.of("a", "b", "c", "d"));
    private static final Prizes prizes = new Prizes(List.of("A", "B", "C", "D"), names);

    @DisplayName("체크 패턴이고 높이가 4인 경우, 사다리 순회가 정상적으로 동작한다.")
    @ParameterizedTest
    @CsvSource({"a, D", "b, C", "c, B", "d, A"})
    void calculatePrizeTest(String target, String expected) {
        //then
        Name name = new Name(target);
        Ladder ladder = new Ladder(new CheckPatternBridgeConstructStrategy(), names, prizes, DEFAULT_HEIGHT);

        //when
        Result result = ladder.calculateResult(name);

        //then
        Assertions.assertThat(result.getPrize()).isEqualTo(expected);
    }

    @DisplayName("체크 패턴이고 높이가 5인 경우, 사다리 순회가 정상적으로 동작한다.")
    @ParameterizedTest
    @CsvSource({"a, C", "b, D", "c, A", "d, B"})
    void calculatePrizeTest2(String target, String expected) {
        //then
        Name name = new Name(target);
        Ladder ladder = new Ladder(new CheckPatternBridgeConstructStrategy(), names, prizes, new Height(5));

        //when
        Result result = ladder.calculateResult(name);

        //then
        Assertions.assertThat(result.getPrize()).isEqualTo(expected);
    }
}
