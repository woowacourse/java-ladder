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
    void invalidMinHeightTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("이오")));
        Assertions.assertThatThrownBy(() -> new LadderGame(input, new Height(5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("플레이어가 2명 이상이면 통과하는 테스트")
    void validMinHeightTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("이오"), new Player("이리내")));
        assertThatCode(() -> new LadderGame(input, new Height(5))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어가 30명 이하이면 통과하는 테스트")
    void validMaxHeightTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("1"), new Player("2"), new Player("3"), new Player("4"), new Player("5"), new Player("6"), new Player("7"), new Player("8"), new Player("9"), new Player("10"),
                new Player("11"), new Player("12"), new Player("13"), new Player("14"), new Player("15"), new Player("16"), new Player("17"), new Player("18"), new Player("19"), new Player("20"),
                new Player("21"), new Player("22"), new Player("23"), new Player("24"), new Player("25"), new Player("26"), new Player("27"), new Player("28"), new Player("29"), new Player("30")));
        assertThatCode(() -> new LadderGame(input, new Height(5))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("플레이어가 30명 초과이면 예외처리 테스트")
    void invalidMaxHeightTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("1"), new Player("2"), new Player("3"), new Player("4"), new Player("5"), new Player("6"), new Player("7"), new Player("8"), new Player("9"), new Player("10"),
                new Player("11"), new Player("12"), new Player("13"), new Player("14"), new Player("15"), new Player("16"), new Player("17"), new Player("18"), new Player("19"), new Player("20"),
                new Player("21"), new Player("22"), new Player("23"), new Player("24"), new Player("25"), new Player("26"), new Player("27"), new Player("28"), new Player("29"), new Player("30"), new Player("31")));
        Assertions.assertThatThrownBy(() -> new LadderGame(input, new Height(5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 생성 테스트")
    void generateLadderTest() {
        List<Player> input = new ArrayList<>(List.of(new Player("a"), new Player("asd"), new Player("qwert")));

        LadderGame ladderGame = new LadderGame(input, new Height(2));
        ladderGame.generateLadder(new TestLineCreateDecider(newArrayList(true, false, false, true)));

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
