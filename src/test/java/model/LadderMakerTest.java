package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import strategy.PassGenerator;
import strategy.RandomPassGenerator;

@DisplayNameGeneration(ReplaceUnderscores.class)
class LadderMakerTest {

    @Nested
    class findLadder_테스트 {

        @Test
        void findLadder_메소드는_ladder가_초기화_되기_전에_호출되면_예외가_발생한다() {
            PassGenerator generator = new RandomPassGenerator();
            LadderMaker ladderMaker = new LadderMaker(generator);

            assertThatThrownBy(ladderMaker::findLadder)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("사다리가 생성되지 않았습니다.");
        }

        @Test
        void findLadder_메소드는_ladder가_초기화한_이후_호출하면_ladder를_반환한다() {
            PassGenerator generator = new RandomPassGenerator();
            Height height = new Height(5);
            LadderMaker ladderMaker = new LadderMaker(generator);
            ladderMaker.initLadder(height, 4);

            assertThatCode(ladderMaker::findLadder).doesNotThrowAnyException();
        }
    }
}
