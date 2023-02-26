package domain;

import dto.LineDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLadderGeneratorTest {

    @DisplayName("생성된 사다리의 높이 너비는 인자로 넘어간 수와 같아야한다.")
    @Test
    void generateTest() {
        final RandomLadderGenerator randomLadderGenerator = new RandomLadderGenerator();
        final List<Line> ladder = randomLadderGenerator.generate(new Width(3), new Height(4));
        final Line line = ladder.get(0);

        final LineDTO lineDTO = line.getLineDTO();

        assertThat(ladder.size()).isEqualTo(4);
        assertThat(lineDTO.getLine().size()).isEqualTo(3);
    }
}
