package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import laddergame.domain.strategy.BuildStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리")
public class LadderTest {
    private static final Point truePoint = new Point(true);
    private static final Point falsePoint = new Point(false);

    @Test
    @DisplayName("생성에 성공한다.")
    public void createLadderTest() {
        //given
        final Height height = new Height("4");
        final Players players = Players.from(List.of("choco", "lemon", "clova", "nyang"));
        final Results results = Results.from(List.of("꽝", "꽝", "꽝", "꽝"));

        BuildStrategy buildStrategy = count -> new Points(List.of(truePoint, falsePoint, truePoint));

        //when
        Ladder ladder = new Ladder(players, height, results, buildStrategy);

        //then
        assertEquals(ladder.getLadderSize(), height.getHeight());
        assertEquals(ladder.getLines().get(0).getPoints().points().size(), players.getPlayers().size() - 1);
    }

    @Test
    @DisplayName("결과 생성에 성공한다.")
    public void createResultsTest() {
        //given
        final Height height = new Height("4");
        final Players players = Players.from(List.of("choco", "lemon", "clova", "nyang"));
        final Results results = Results.from(List.of("꽝1", "꽝2", "꽝3", "꽝4"));

        BuildStrategy buildStrategy = count -> new Points(List.of(falsePoint, falsePoint, falsePoint));

        //when
        Ladder ladder = new Ladder(players, height, results, buildStrategy);

        //then
        assertEquals(ladder.find("choco"), "꽝1");
        assertEquals(ladder.find("lemon"), "꽝2");
        assertEquals(ladder.find("clova"), "꽝3");
        assertEquals(ladder.find("nyang"), "꽝4");
    }

    @Test
    @DisplayName("결과에 따라 결과를 정상적으로 찾는다.")
    public void findResultsTest() {
        //given
        final Height height = new Height("5");
        final Players players = Players.from(List.of("choco", "lemon", "clova", "nyang"));
        final Results results = Results.from(List.of("꽝1", "꽝2", "꽝3", "꽝4"));

        BuildStrategy buildStrategy = count -> new Points(List.of(truePoint, falsePoint, truePoint));

        //when
        Ladder ladder = new Ladder(players, height, results, buildStrategy);

        //then
        assertEquals(ladder.find("choco"), "꽝2");
        assertEquals(ladder.find("lemon"), "꽝1");
        assertEquals(ladder.find("clova"), "꽝4");
        assertEquals(ladder.find("nyang"), "꽝3");
    }
}
