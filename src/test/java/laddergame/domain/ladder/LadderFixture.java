package laddergame.domain.ladder;

import laddergame.domain.player.Player;

import java.util.List;

import static laddergame.domain.ladder.Connection.CONNECTED;
import static laddergame.domain.ladder.Connection.UNCONNECTED;

public class LadderFixture {

    protected static Player ethan;
    protected static Player coil;
    protected static Player junPark;
    protected static List<Player> players;
    protected static List<Connection> connections;
    protected static Ladder ladder;

    public LadderFixture() {
        ethan = Player.of("에단", 0);
        coil = Player.of("코일", 1);
        junPark = Player.of("준팍", 2);
        players = List.of(ethan, coil, junPark);

        connections = List.of(CONNECTED, UNCONNECTED);
        ladder = new Ladder(1, players.size(), new TestConnectionMaker(connections));
    }
}
