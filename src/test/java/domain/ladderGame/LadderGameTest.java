package domain.ladderGame;

import domain.generator.MockBooleanGenerator;
import domain.item.Items;
import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.player.Players;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    private static MockBooleanGenerator booleanGenerator;
    private static GameInit gameInit;

    /**
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
     */

    @Test
    @DisplayName("사다리 게임을 실행하고 그 결과를 반환한다.")
    void playLadderGameTest() {
        LinkedHashMap<String, String> expectedResult = new LinkedHashMap<>();
        expectedResult.put("pobi", "당첨1");
        expectedResult.put("honux", "당첨4");
        expectedResult.put("crong", "당첨3");
        expectedResult.put("jk", "당첨2");

        LadderGame ladderGame = new LadderGame(gameInit);
        GameResult gameResult = ladderGame.play();

        assertThat(gameResult.getResults())
                .isEqualTo(expectedResult);
    }

    @BeforeAll
    static void setting() {
        booleanGenerator = new MockBooleanGenerator(
                List.of(true, false, true,
                        false, true, false,
                        true, false, false,
                        false, true, false,
                        true, false, true));

        Players players = new Players(makeTestPlayers());
        Ladder ladder = new Ladder(makeTestLadder());
        Items items = new Items(makeTestItems().size(), makeTestItems());

        gameInit = new GameInit(players, ladder, items);

    }

    private static List<String> makeTestPlayers() {
        return List.of("pobi", "honux", "crong", "jk");
    }

    private static List<Line> makeTestLadder() {
        return List.of(
                new Line(4, booleanGenerator),
                new Line(4, booleanGenerator),
                new Line(4, booleanGenerator),
                new Line(4, booleanGenerator),
                new Line(4, booleanGenerator));
    }

    private static List<String> makeTestItems() {
        return List.of("당첨1", "당첨2", "당첨3", "당첨4");
    }

}