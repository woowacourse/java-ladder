package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.util.Lists.newArrayList;

class LadderGameTest {

    @Test
    @DisplayName("플레이어가 2명 미만이면 예외처리 테스트")
    void invalidHeightTest() {
        List<PlayerName> input = new ArrayList<>(List.of(new PlayerName("이오")));
        Assertions.assertThatThrownBy(() -> new LadderGame(input, new Height(5), new RandomLineCreateDecider()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어가 2명 이상이면 통과하는 테스트")
    void validHeightTest() {
        List<PlayerName> input = new ArrayList<>(List.of(new PlayerName("이오"), new PlayerName("이리내")));
        assertThatCode(() -> new LadderGame(input, new Height(5), new RandomLineCreateDecider())).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("사다리 생성 테스트")
    void generateLadderTest() {
        List<PlayerName> input = new ArrayList<>(List.of(new PlayerName("a"), new PlayerName("asd"), new PlayerName("qwert")));

        LadderGame ladderGame = new LadderGame(input, new Height(2), new TestLineCreateDecider(newArrayList(true, false, false, true)));

        List<Row> rows = ladderGame.getLadder().getRows();

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
