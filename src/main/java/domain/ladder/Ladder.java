package domain.ladder;

import domain.height.Height;
import domain.player.Players;
import domain.prize.Prizes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderRow> rows;
    private final Players players;
    private final Prizes prizes;

    private Ladder(List<LadderRow> rows, Players players, Prizes prizes) {
        this.rows = rows;
        this.players = players;
        this.prizes = prizes;
    }

    public static Ladder create(Height height, Players players, Prizes prizes,
                                LadderRungGenerator ladderRungGenerator) {
        int width = players.getPlayerCount() - 1;
        List<LadderRow> rows = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            LadderRow ladderRow = LadderRow.create(width, ladderRungGenerator);
            rows.add(ladderRow);
        }
        return new Ladder(rows, players, prizes);
    }

    public List<String> climb() {
        List<String> playerNames = new ArrayList<>(players.getNames());
        for (LadderRow row : rows) {
            row.crossRungs(playerNames);
        }
        return playerNames;
    }

    public List<LadderRow> getRows() {
        return Collections.unmodifiableList(rows);
    }
}
