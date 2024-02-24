package domain.ladderTest;

import domain.Height;
import domain.Ladder;
import domain.Names;
import domain.Prizes;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LadderFindPrizeTest {

    private static final Height DEFAULT_HEIGHT = new Height(4);
    private static final Names names = new Names(List.of("a", "b", "c", "d"));
    private static final Prizes prizes = new Prizes(List.of("A", "B", "C", "D"), names);

    @DisplayName("체크 패턴이고 높이가 4인 경우, 사다리 순회가 정상적으로 동작한다.")
    @ParameterizedTest
    @CsvSource({"a, D", "b, C", "c, B", "d, A"})
    void calculatePrizeTest(String name, String expected) {
        //then
        Ladder ladder = new Ladder(new CheckPatternBridgeConstructStrategy(), names, prizes, DEFAULT_HEIGHT);

        //when
        String result = ladder.findPrizeByName(name);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @DisplayName("체크 패턴이고 높이가 5인 경우, 사다리 순회가 정상적으로 동작한다.")
    @ParameterizedTest
    @CsvSource({"a, C", "b, D", "c, A", "d, B"})
    void calculatePrizeTest2(String name, String expected) {
        //then
        Ladder ladder = new Ladder(new CheckPatternBridgeConstructStrategy(), names, prizes, new Height(5));

        //when
        String result = ladder.findPrizeByName(name);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
