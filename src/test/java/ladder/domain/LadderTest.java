package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LadderTest {
    @Test
    public void 생성_success() {
        assertThatNoException()
                .isThrownBy(() -> new Ladder(generateRowList()));
    }

    @ParameterizedTest
    @CsvSource({"0,2", "1,0", "2,1", "3,3", "4,4"})
    void should_사다리를태우다_when_초기위치가주어지면(int beforeMove, int expected) {
        // given
        Ladder ladder = new Ladder(generateRowList());
        Position initialPosition = new Position(beforeMove);

        // when
        Position destination = ladder.climbDownFrom(initialPosition);

        //then
        assertThat(destination).isEqualTo(new Position(expected));
    }

    static List<Row> generateRowList() {
        return List.of(
                Row.of(List.of(Foothold.PASSABLE, Foothold.BLOCKED, Foothold.BLOCKED, Foothold.PASSABLE), 4),
                Row.of(List.of(Foothold.BLOCKED, Foothold.PASSABLE, Foothold.BLOCKED, Foothold.PASSABLE), 4)
        );
    }
}
