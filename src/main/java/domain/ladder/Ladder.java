package domain.ladder;

import domain.height.Height;
import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<LadderRow> rows;

    private Ladder(List<LadderRow> rows) {
        this.rows = rows;
    }

    public static Ladder create(Height height, Players players, BooleanGenerator booleanGenerator) {
        List<LadderRow> ladderRows = new ArrayList<>();
        for (int count = 0; count < height.getValue(); count++) {
            LadderRow ladderRow = LadderRow.create(players.count(), booleanGenerator);
            ladderRows.add(ladderRow);
        }
        return new Ladder(ladderRows);
    }

    public LadderResult climb(Players players, Prizes prizes) {
        Map<Player, Prize> result = new LinkedHashMap<>();
        for (int start = 0; start < players.count(); start++) {
            int end = crossRow(start);
            result.put(players.findPlayerByIndex(start), prizes.findPrizeByIndex(end));
        }
        return new LadderResult(result);
    }

    private int crossRow(int index) {
        for (LadderRow row : rows) {
            index = row.move(index);
        }
        return index;
    }

    public List<LadderRow> getRows() {
        return Collections.unmodifiableList(rows);
    }
}
