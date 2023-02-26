package domain.player;

import domain.generator.MockBooleanGenerator;
import domain.item.Item;
import domain.ladder.Ladder;
import domain.ladder.Line;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private static MockBooleanGenerator booleanGenerator;
    private static Ladder ladder;
    private static List<Item> items;

    /**
     * ParameterizedTest의 MethodSource인 generatePlayer 로 순차적으로 생성한 Player와
     * @BeforeAll의 setting() 으로 사다리 및 아이템 생성한 후의
     * 사다리게임 초기화 상황
     *
     *  pobi honux crong    jk
     *     |-----|     |-----|
     *     |     |-----|     |
     *     |-----|     |     |
     *     |     |-----|     |
     *     |-----|     |-----|
     *  당첨1   당첨2   당첨3   당첨4
     *
     * 사다리 결과
     * pobi : 당첨1
     * honux : 당첨4
     * crong : 당첨3
     * jk : 당첨2
     **/

    @ParameterizedTest
    @MethodSource("generatePlayer")
    @DisplayName("참가자가 사다리를 타고 내려가서 당첨 결과를 받는다.")
    void findGameResultTest(Player player, String result) {
        player.findGameResult(ladder, items);
        assertThat(player.getResult()).isEqualTo(result);
    }

    private static Stream<Arguments> generatePlayer() {
        return Stream.of(
                Arguments.arguments(new Player("pobi", 0), "당첨1"),
                Arguments.arguments(new Player("honux", 1), "당첨4"),
                Arguments.arguments(new Player("crong", 2), "당첨3"),
                Arguments.arguments(new Player("jk", 3), "당첨2")
        );
    }

    @BeforeAll
    static void setting() {
        booleanGenerator = new MockBooleanGenerator(
                List.of(true, false, true,
                        false, true, false,
                        true, false, false,
                        false, true, false,
                        true, false, true));

        ladder = new Ladder(makeTestLadder());
        items = makeTestItems();
    }

    private static List<Line> makeTestLadder() {
        return List.of(
                new Line(4, booleanGenerator),
                new Line(4, booleanGenerator),
                new Line(4, booleanGenerator),
                new Line(4, booleanGenerator),
                new Line(4, booleanGenerator));
    }

    private static List<Item> makeTestItems() {
        return List.of(
                new Item("당첨1"),
                new Item("당첨2"),
                new Item("당첨3"),
                new Item("당첨4"));
    }
}