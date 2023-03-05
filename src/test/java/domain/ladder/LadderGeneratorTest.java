package domain.ladder;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;

@DisplayName("사다리 생성기는")
class LadderGeneratorTest {

    @Test
    @DisplayName(" 크기와 높이를 받아서 사다리를 생성한다.")
    void generateLadder() {
        //given
        BooleanGenerator generator = new RandomBooleanGenerator();
        int height = 2;
        int width = 5;

        //when
        Ladder ladder = LadderGenerator.build(height, width, generator);

        //then
        int generatedLadderHeight = ladder.getLadderShape().size();
        int generatedLadderWidth = ladder.getLadderShape().get(0).size();
        assertThat(generatedLadderWidth).isEqualTo(width);
        assertThat(generatedLadderHeight).isEqualTo(height);
    }
}
