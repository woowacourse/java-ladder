package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

class LadderGeneratorTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void generateLadderTest() {
        LadderGenerator ladderGenerator = new LadderGenerator(new TestLineCreateDecider(newArrayList(true, false, false, true)));

        List<Row> rows = ladderGenerator.generateLadder(3, new Height(2)).getRows();

        Assertions.assertThat(rows.get(0).getPoints()).containsExactly(true, false);
        Assertions.assertThat(rows.get(1).getPoints()).containsExactly(false, true);
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
