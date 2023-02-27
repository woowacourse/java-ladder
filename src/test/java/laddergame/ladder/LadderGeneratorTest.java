package laddergame.ladder;

import laddergame.RandomBooleanGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGeneratorTest {
    @Nested
    class Ladder생성기능 {
        @ParameterizedTest
        @CsvSource({"2,2", "2,3", "3,5"})
        void test_generate_should_높이와너비에맞는사다리생성된다_when_높이와너비가주어진경우(int height, int width) {
            // given
            LadderHeight ladderHeight = new LadderHeight(height);
            LadderWidth ladderWidth = new LadderWidth(width);
            RowGenerator rowGenerator = new RowGenerator(new RandomBooleanGenerator());
            LadderGenerator ladderGenerator = new LadderGenerator(rowGenerator);

            // when
            Ladder ladder = ladderGenerator.generate(ladderWidth, ladderHeight);

            //then
            assertAll(
                    () -> assertThat(ladder.getHeight()).isEqualTo(height),
                    () -> assertThat(ladder.getWidth()).isEqualTo(width)
            );
        }
    }
}
