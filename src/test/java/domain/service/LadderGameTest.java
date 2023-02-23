package domain.service;

import domain.model.Ladder;
import domain.model.Layer;
import domain.model.Player;
import domain.model.Players;
import domain.vo.Height;
import domain.vo.Name;
import domain.vo.Width;
import domain.wrapper.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderGameTest {

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

    @ParameterizedTest(name = "{0}이 사다리 높이 만큼 이동했을 때의 위치는 ({1}, 3)")
    @CsvSource(value = {"p1:3", "p2:1", "p3:2", "p4:0"}, delimiter = ':')
    void play(String name, int xPosition) {
        LadderGame ladderGame = new LadderGame(ladder, players);

        ladderGame.play();

        players = ladderGame.getPlayers();

        Player player = players.findByName(name);

        assertThat(player.getXPosition()).isEqualTo(xPosition);
        assertThat(player.getYPosition()).isEqualTo(3);
    }
}