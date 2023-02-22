package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LadderTest {
    List<Row> generateRowList() {
        return List.of(
                Row.of(List.of(Foothold.PASSABLE, Foothold.BLOCKED, Foothold.BLOCKED, Foothold.PASSABLE), 4),
                Row.of(List.of(Foothold.BLOCKED, Foothold.PASSABLE, Foothold.BLOCKED, Foothold.PASSABLE), 4)
        );
    }

    @Test
    public void 생성_success() {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(generateRowList()));
    }

    @ParameterizedTest(name = "초기위치로 pass하면 사다리를 내려간다")
    @CsvSource({"0,2", "1,0", "2,1", "3,3", "4,4"})
    void 사다리_이동(int beforeMove, int expected) {
        // given
        Ladder ladder = new Ladder(generateRowList());
        PlayerPosition initialPosition = new PlayerPosition(beforeMove);

        // when
        PlayerPosition destination = ladder.passFrom(initialPosition);

        //then
        assertThat(destination).isEqualTo(new PlayerPosition(expected));
    }

    @DisplayName()
    @Test
    void 테스트() {
        // given
        Ladder ladder = new Ladder(generateRowList());
        List<String> names = List.of("에밀", "파워", "오리", "져니", "매튜");
        List<String> prizes = List.of("0", "1", "2", "3", "4");
        Players players = Players.from(names);
        Map<String, String> expected = new HashMap<>();
        expected.put("에밀", "2");
        expected.put("파워", "0");
        expected.put("오리", "1");
        expected.put("져니", "3");
        expected.put("매튜", "4");

        // when
        Map<String, String> result = ladder.runGame(players, prizes);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
