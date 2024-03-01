package domain.ladder;

import domain.height.Height;
import domain.player.Name;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private static final String PLAYER_PRIZE_COUNT_EXCEPTION_MESSAGE = "[ERROR] 참가자 수: %d, 상품 수: %d - 두 수는 같아야 합니다.";

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
        validatePlayersAndPrizesCount(players, prizes);
        int width = players.count() - 1;
        List<LadderRow> rows = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            LadderRow ladderRow = LadderRow.create(width, ladderRungGenerator);
            rows.add(ladderRow);
        }
        return new Ladder(rows, players, prizes);
    }

    private static void validatePlayersAndPrizesCount(Players players, Prizes prizes) {
        int playerCount = players.count();
        int prizeCount = prizes.count();
        if (playerCount != prizeCount) {
            throw new IllegalArgumentException(
                    String.format(PLAYER_PRIZE_COUNT_EXCEPTION_MESSAGE, playerCount, prizeCount)
            );
        }
    }

    public LadderResult climb() {
        Map<Name, Prize> result = new LinkedHashMap<>();
        for (int start = 0; start < players.count(); start++) {
            int end = crossRow(start);
            result.put(players.get(start), prizes.get(end));
        }
        return new LadderResult(result);
    }

    private int crossRow(int index) {
        for (LadderRow row : rows) {
            index = row.crossRung(index);
        }
        return index;
    }

    public List<LadderRow> getRows() {
        return Collections.unmodifiableList(rows);
    }
}
