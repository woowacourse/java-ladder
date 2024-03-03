package domain;

import domain.ladder.DirectionalPoint;
import domain.ladder.Ladder;
import domain.ladder.LadderRow;
import domain.player.Player;
import domain.player.Players;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;

    public LadderGame(final Ladder ladder, final Players players) {
        this.ladder = ladder;
        this.players = players;
    }

    public void play() {
        final List<LadderRow> ladderRows = ladder.getLadderRows();
        for (LadderRow ladderRow : ladderRows) {
            final List<DirectionalPoint> ladderPoints = ladderRow.getLadderPoints();
            playRow(ladderPoints);
        }
    }

    private void playRow(final List<DirectionalPoint> ladderPoints) {
        for (int i = 0; i < ladderPoints.size(); i++) {
            Player player = players.findPlayerByIndex(i);
            player.move(ladderPoints.get(player.getPosition()).getDirection());
        }
    }
}
