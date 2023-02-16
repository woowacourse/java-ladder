package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.util.Lists.newArrayList;

class LadderGameTest {

    @Test
    @DisplayName("플레이어가 2명 미만이면 예외처리 테스트")
    void invalidHeightTest() {
        List<PlayerName> input = new ArrayList<>(List.of(new PlayerName("이오")));
        Assertions.assertThatThrownBy(() -> new LadderGame(input, new RandomLineCreateDecider()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어가 2명 이상이면 통과하는 테스트")
    void validHeightTest() {
        List<PlayerName> input = new ArrayList<>(List.of(new PlayerName("이오"), new PlayerName("이리내")));
        assertThatCode(() -> new LadderGame(input, new RandomLineCreateDecider())).doesNotThrowAnyException();
    }


    @Test
    @DisplayName("사다리 생성 테스트")
    void generateLadderTest() {
        List<PlayerName> input = new ArrayList<>(List.of(new PlayerName("a"), new PlayerName("asd"), new PlayerName("qwert")));

        LadderGame ladderGame = new LadderGame(input, new TestLineCreateDecider(newArrayList(true, false, true)));
        ladderGame.generateLadder(new Height(2));
        List<Row> rows = ladderGame.getLadder().getRows();

        assertThat(rows.get(0).isPointHasLine(0)).isTrue();
        assertThat(rows.get(0).isPointHasLine(1)).isFalse();
        assertThat(rows.get(1).isPointHasLine(0)).isFalse();
        assertThat(rows.get(1).isPointHasLine(1)).isTrue();
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