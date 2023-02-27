package domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayersTest {

    Players players;
    Ladder ladder;

    @BeforeEach
    void setUp() {
        players = Players.from(List.of("p1", "p2", "p3", "p4"));

        ladder = new Ladder(3, 4);

        Layer layer1 = new Layer();
        layer1.makeLine(true);
        layer1.makeLine(false);
        layer1.makeLine(true);

        Layer layer2 = new Layer();
        layer2.makeLine(false);
        layer2.makeLine(true);
        layer2.makeLine(false);

        Layer layer3 = new Layer();
        layer3.makeLine(true);
        layer3.makeLine(false);
        layer3.makeLine(true);

        ladder.addLayer(layer1);
        ladder.addLayer(layer2);
        ladder.addLayer(layer3);
    }

    @ParameterizedTest(name = "{0}이 1회 이동했을때의 순서는 {1} ")
    @CsvSource(value = {"p1:1", "p2:0", "p3:3", "p4:2"}, delimiter = ':')
    void moveAll(String name, int expectedX) {
        players.moveAll(ladder);

        int order = players.orderByName(name);
        assertThat(order).isEqualTo(expectedX);
    }

    @ParameterizedTest(name = "사다리를 모두 이동했을 때 {0}의 위치는 {1}")
    @CsvSource(value = {"p1:3", "p2:1", "p3:2", "p4:0"}, delimiter = ':')
    void orderByName(String name, int expected) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            players.moveAll(ladder);
        }

        assertThat(players.orderByName(name)).isEqualTo(expected);
    }
}