package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class LadderTest {

    @Test
    @DisplayName("주어진 입구에 따른 출구를 잘 찾는지 테스트")
    void findExitTest() {
        LadderGenerator generator = new LadderGenerator(new LadderGeneratorTest.TestLineCreateDecider(newArrayList(true, false, false, true)));
        Ladder ladder = generator.generateLadder(3, new Height(2));

        assertThat(ladder.findExitFrom(0)).isEqualTo(2);
        assertThat(ladder.findExitFrom(1)).isEqualTo(0);
        assertThat(ladder.findExitFrom(2)).isEqualTo(1);
    }

    static class TestLineCreateDecider implements LineCreateDecider {

        private final List<Boolean> isCreated;

        TestLineCreateDecider(List<Boolean> isCreated) {
            this.isCreated = isCreated;
        }

        @Override
        public boolean decide() {
            return isCreated.remove(0);
        }

    }
}
