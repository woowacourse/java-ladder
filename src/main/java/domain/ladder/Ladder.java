package domain.ladder;

import domain.height.Height;
import domain.player.Players;
import domain.prize.Prizes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
