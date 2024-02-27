package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.mock.MockRungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FloorTest {

    @Test
    @DisplayName("라인 내 발판들을 생성한다.")
    void generateRungs() {
        List<Rung> rungs = List.of(Rung.EXIST, Rung.EMPTY);
        Floor floor = new Floor(3, new MockRungGenerator(rungs));

        assertThat(floor.getRungs()).containsExactly(Rung.EXIST, Rung.EMPTY);
    }

    @Test
    @DisplayName("연속된 발판들은 생성되지 않는다.")
    void invalidGenerateRungsV1() {
        List<Rung> rungs = List.of(Rung.EXIST, Rung.EXIST);
        Floor floor = new Floor(3, new MockRungGenerator(rungs));

        assertThat(floor.getRungs()).containsExactly(Rung.EXIST, Rung.EMPTY);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 0", "2, 3", "3, 2"}, delimiter = ',')
    @DisplayName("발판으로 연결된 인덱스를 찾는다.")
    void findConnectedIndex(int index, int expected) {
        List<Rung> rungs = List.of(Rung.EXIST, Rung.EMPTY, Rung.EXIST);
        Floor floor = new Floor(4, new MockRungGenerator(rungs));

        assertThat(floor.findConnectedIndex(index)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 0", "2, 3", "3, 2"}, delimiter = ',')
    @DisplayName("사다리의 시작 인덱스로 마지막 인덱스를 찾는다.")
    void findEndIndex(int index, int expected) {
        List<Rung> rungs = List.of(Rung.EXIST, Rung.EMPTY, Rung.EXIST);
        Floor floor = new Floor(4, new MockRungGenerator(rungs));

        assertThat(floor.findConnectedIndex(index)).isEqualTo(expected);
    }
}
