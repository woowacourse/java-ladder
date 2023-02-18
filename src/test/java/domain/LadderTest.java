package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("다리가 높이와 라인 수를 입력받고, 각 라인들에 높이만큼의 크기를 가진 Point 리스트를 생성한다")
    @Test
    void create_success() {
        // given
        Ladder ladder = createLadder(3,3);

        // when
        List<Line> lines = ladder.getLines();
        int numberOfPoint = lines.stream()
                .map(line -> line.getPoints().size())
                .collect(Collectors.toSet())
                .size();

        // then
        assertThat(numberOfPoint).isEqualTo(1);
    }

    private Ladder createLadder(int numberOfPeople, int height) {
        LadderHeight ladderHeight = new LadderHeight(height);
        Ladder ladder = Ladder.create(numberOfPeople, ladderHeight, new RandomNumberGenerator());
        return ladder;
    }
}
