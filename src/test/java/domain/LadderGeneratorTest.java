package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomNumberGenerator;

class LadderGeneratorTest {

    private final LadderGenerator ladderGenerator = new LadderGenerator(new RandomNumberGenerator());

    @DisplayName("다리가 높이와 라인 수를 입력받고, 각 라인들에 높이만큼의 크기를 가진 Point 리스트를 생성한다")
    @Test
    void create_success() {
        // given
        Ladder ladder = ladderGenerator.generate(3, new LadderHeight(3));

        // when
        List<Line> lines = ladder.getLines();
        int numberOfPoint = lines.stream()
                .map(line -> line.getPoints().size())
                .collect(Collectors.toSet())
                .size();

        // then
        assertThat(numberOfPoint).isEqualTo(1);
    }

}