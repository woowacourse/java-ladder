package laddergame.domain;

import laddergame.domain.strategy.ZonesBuilder;
import laddergame.util.RandomZoneGenerator;
import laddergame.util.ZoneGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("사다리")
public class LadderTest {
    @Test
    @DisplayName("생성에 성공한다.")
    public void createLadderTest() {
        //given
        final Height height = new Height("4");
        final List<String> playersName = List.of("name1", "name2");
        final Players players = new Players(playersName);

        //when
        Ladder ladder = new Ladder(
                new ZonesBuilder(new RandomZoneGenerator()),
                players,
                height);

        //then
        assertEquals(ladder.getLines().size(), height.getHeight());
        assertEquals(ladder.getLines().get(0).getZones().size(), playersName.size() - 1);
    }

    @Test
    @DisplayName("사다리 다리 건설 생성에 성공하는지 테스트한다.")
    public void buildLadderBridge() {
        //given
        final Height height = new Height("1");
        final List<String> playersName = List.of("name1", "name2", "name3", "name4");
        final Players players = new Players(playersName);
        final List<Zone> expected = List.of(Zone.EMPTY, Zone.EMPTY, Zone.EMPTY);

        ZoneGenerator zoneGenerator = new ZoneGenerator() {
            @Override
            public Zone generate() {
                return Zone.EMPTY;
            }
        };
        ZonesBuilder lineBuildStrategy = new ZonesBuilder(zoneGenerator);

        //when
        Ladder ladder = new Ladder(lineBuildStrategy, players, height);

        //then
        assertEquals(expected, ladder.getLines().get(0).getZones());
    }
}
