package domain.ladder;

import domain.height.Height;
import domain.player.Players;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<LadderRow> rows;

    private Ladder(List<LadderRow> rows) {
        this.rows = rows;
    }

    public static Ladder create(Height height, Players players, LadderRungGenerator ladderRungGenerator) {
        List<LadderRow> rows = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            final LadderRow ladderRow = LadderRow.create(players.getPlayerCount() - 1, ladderRungGenerator);
            rows.add(ladderRow);
        }
        return new Ladder(rows);
    }

    public List<String> climb(Players players) {
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
