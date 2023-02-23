package laddergame.domain.prize;

import laddergame.domain.player.Names;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.List;

public class ResultsFixture {
    protected static Players players;
    protected static Prizes prizes;
    protected static Results results;
    protected static Player ethan;
    protected static Player coil;
    protected static Player junPk;

    public ResultsFixture() {
        ethan = Player.of("ethan", 0);
        coil = Player.of("coil", 1);
        junPk = Player.of("junPk", 2);
        players = new Players(new Names(List.of(ethan.getName(), coil.getName(), junPk.getName())));

        prizes = new Prizes(List.of("1000", "5000", "10000"), players.getPlayerSize());
        results = new Results(players, prizes);
    }
}
