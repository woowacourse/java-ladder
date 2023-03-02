package domain;


import static domain.LineTest.PASSABLE_THRESHOLDS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;

class LadderTest {

    @DisplayName("다리가 높이와 라인 수를 입력받고, 각 라인들에 높이만큼의 크기를 가진 Point 리스트를 생성한다")
    @Test
    void create_success() {
        Ladder ladder = createLadder(3, 3);

        List<Line> lines = ladder.lines();

        int numberOfPoint = lines.stream()
                .map(line -> line.points().size())
                .collect(Collectors.toSet())
                .size();

        assertThat(numberOfPoint).isEqualTo(1);
    }

    @DisplayName("사다리의 시작 위치가 같다면 같은 결과 위치를 반환해주어야한디")
    @Test
    void get_same_start_end_position() {
        Ladder ladder = createLadder(2, 3);
        Position first = ladder.getResultPositionOf(new Position(0));
        Position second = ladder.getResultPositionOf(new Position(0));
        assertThat(first).isEqualTo(second);
    }

    @DisplayName("사다리의 시작 위치가 다르다면 서로 다른 결과 위치를 반환해주어야 한다.")
    @Test
    void get_different_start_end_position() {
        Ladder ladder = createLadder(2, 3);
        Position first = ladder.getResultPositionOf(new Position(0));
        Position second = ladder.getResultPositionOf(new Position(1));
        assertThat(first).isNotEqualTo(second);
    }

    /** 0     1     2     3
     *  |-----|     |-----|
     *  |     |-----|     |
     *  |-----|     |-----|
     *  0     1     2     3
     *  이면  0->3, 1->1, 2->2, 3->0
     * **/
    @ParameterizedTest(name = "사다리의 결과에 맞는 시작, 결과 위치를 반환해주어야 한다. 시작: {0}, 결과: {1}")
    @CsvSource(value = {"0:3", "1:1", "2:2", "3:0"}, delimiter = ':')
    void get_appropriate_position(int startPosition, int expectedResultPositionValue) {
        List<Integer> numberListToGenerate = List.of(PASSABLE_THRESHOLDS, PASSABLE_THRESHOLDS,
                PASSABLE_THRESHOLDS - 1, PASSABLE_THRESHOLDS,
                PASSABLE_THRESHOLDS, PASSABLE_THRESHOLDS);
        Ladder ladder = createLadder(3, 4, new MockNumberGenerator(numberListToGenerate));

        Position realResultPosition = ladder.getResultPositionOf(new Position(startPosition));

        assertThat(realResultPosition.value()).isEqualTo(expectedResultPositionValue);
    }

    private Ladder createLadder(int height, int numberOfPeople) {
        LadderHeight ladderHeight = new LadderHeight(height, numberOfPeople);
        Ladder ladder = Ladder.of(numberOfPeople, ladderHeight, new RandomNumberGenerator());
        return ladder;
    }

    public Ladder createLadder(int height, int numberOfPeople, NumberGenerator numberGenerator) {
        LadderHeight ladderHeight = new LadderHeight(height, numberOfPeople);
        Ladder ladder = Ladder.of(numberOfPeople, ladderHeight, numberGenerator);
        return ladder;
    }
}
