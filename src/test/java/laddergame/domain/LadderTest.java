package laddergame.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
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
        final Results results = Results.from(List.of("꽝", "꽝", "꽝", "꽝"), players.getPlayersSize());

        BuildStrategy buildStrategy = count -> new Points(List.of(truePoint, falsePoint, truePoint));

        //when
        Ladder ladder = new Ladder(players, height, results, buildStrategy);

        //then
        assertEquals(ladder.getLadderSize(), height.getHeight());
        assertEquals(ladder.getLine(0).getPoints().getPointSize(), players.getPlayersSize() - 1);
    }

    @Test
    @DisplayName("결과 생성에 성공한다.")
    public void createResultsTest() {
        //given
        final Height height = new Height("4");
        final Players players = Players.from(List.of("choco", "lemon", "clova", "nyang"));
        final Results results = Results.from(List.of("꽝1", "꽝2", "꽝3", "꽝4"), players.getPlayersSize());

        BuildStrategy buildStrategy = count -> new Points(List.of(falsePoint, falsePoint, falsePoint));

        //when
        Ladder ladder = new Ladder(players, height, results, buildStrategy);

        //then
        assertEquals(ladder.find("choco"), results.getResults().get(0));
        assertEquals(ladder.find("lemon"), results.getResults().get(1));
        assertEquals(ladder.find("clova"), results.getResults().get(2));
        assertEquals(ladder.find("nyang"), results.getResults().get(3));
    }

    @Test
    @DisplayName("결과에 따라 결과를 정상적으로 찾는다.")
    public void findResultsTest() {
        //given
        final Height height = new Height("5");
        final Players players = Players.from(List.of("choco", "lemon", "clova", "nyang"));
        final Results results = Results.from(List.of("꽝1", "꽝2", "꽝3", "꽝4"), players.getPlayersSize());

        BuildStrategy buildStrategy = count -> new Points(List.of(truePoint, falsePoint, truePoint));

        //when
        Ladder ladder = new Ladder(players, height, results, buildStrategy);

        //then
        assertEquals(ladder.find("choco"), results.getResults().get(1));
        assertEquals(ladder.find("lemon"), results.getResults().get(0));
        assertEquals(ladder.find("clova"), results.getResults().get(3));
        assertEquals(ladder.find("nyang"), results.getResults().get(2));
    }

    @Test
    @DisplayName("플레이어 전체 결과 반환에 성공한다.")
    public void getPlayersResultsTest() {
        //given
        final Height height = new Height("5");
        final Players players = Players.from(List.of("choco", "lemon", "clova", "nyang"));
        final Results results = Results.from(List.of("꽝1", "꽝2", "꽝3", "꽝4"), players.getPlayersSize());

        BuildStrategy buildStrategy = count -> new Points(List.of(falsePoint, falsePoint, falsePoint));

        //when
        Ladder ladder = new Ladder(players, height, results, buildStrategy);
        final PlayersResults playersResults = ladder.getPlayersResults();

        //then
        assertEquals(playersResults.find("choco").name(), "꽝1");
        assertEquals(playersResults.find("lemon").name(), "꽝2");
        assertEquals(playersResults.find("clova").name(), "꽝3");
        assertEquals(playersResults.find("nyang").name(), "꽝4");
    }

    @Test
    @DisplayName("플레이어 전체 결과는 순서대로 반환된다.")
    public void getPlayerResultsInOrder() {
        //given
        final Height height = new Height("5");
        final Players players = Players.from(List.of("choco", "lemon", "clova", "nyang"));
        final Results results = Results.from(List.of("꽝1", "꽝2", "꽝3", "꽝4"), players.getPlayersSize());

        BuildStrategy buildStrategy = count -> new Points(List.of(falsePoint, falsePoint, falsePoint));

        //when
        Ladder ladder = new Ladder(players, height, results, buildStrategy);
        final PlayersResults playersResults = ladder.getPlayersResults();
        List<Player> playersToTest = new ArrayList<>();
        for (Entry<Player, Result> entry : playersResults.playerResults().entrySet()) {
            playersToTest.add(entry.getKey());
        }

        //then
        assertEquals(playersToTest.get(0).getName(), "choco");
        assertEquals(playersToTest.get(1).getName(), "lemon");
        assertEquals(playersToTest.get(2).getName(), "clova");
        assertEquals(playersToTest.get(3).getName(), "nyang");
    }
}
