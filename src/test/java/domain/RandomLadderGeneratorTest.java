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
        final Ladder ladder = randomLadderGenerator.generate(3, new Height(4));
        final List<Line> ladderLines = ladder.getLadder();
        final LineDTO lineDTO = ladderLines.get(0).getLineDTO();

        assertThat(ladderLines.size()).isEqualTo(4);
        assertThat(lineDTO.getLineDTO().size()).isEqualTo(3);
    }
}
