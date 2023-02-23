package domain.model;

import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Width;
import domain.wrapper.Position;
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
        players = new Players();
        Player player1 = Player.of(new Name("p1"), Position.of(0));
        Player player2 = Player.of(new Name("p2"), Position.of(1));
        Player player3 = Player.of(new Name("p3"), Position.of(2));
        Player player4 = Player.of(new Name("p4"), Position.of(3));
        players.addAll(List.of(player1, player2, player3, player4));

        ladder = new Ladder(new Height(3), new Width(4));

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

    @ParameterizedTest(name = "{0}이 1회 이동했을때의 좌표는({1},{2}) ")
    @CsvSource(value = {"p1:1:1", "p2:0:1", "p3:3:1", "p4:2:1"}, delimiter = ':')
    void moveAll(String name, int expectedX, int expectedY) {
        players.moveAll(ladder);

        Player player = players.findByName(name);
        assertThat(player.getXPosition()).isEqualTo(expectedX);
        assertThat(player.getYPosition()).isEqualTo(expectedY);
    }


}