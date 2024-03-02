package model.laddergame;

import controller.dto.PrizeResult;
import controller.dto.PrizesResult;
import java.util.ArrayList;
import java.util.List;
import model.ladder.Ladder;
import model.players.Players;
import model.players.Position;
import model.prize.Prize;
import model.prize.Prizes;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;

    public LadderGame(final Players players, Ladder ladder, final Prizes prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public Prize move(String name) {
        Position position = players.findPositionByName(name);
        return prizes.getPrizeByIndex(ladder.move(position));
    }

    public PrizesResult moveAll() {
        List<PrizeResult> results = new ArrayList<>();
        for (String name : players.getNames()) {
            Prize prize = move(name);
            results.add(new PrizeResult(name, prize.getName()));
        }
        return new PrizesResult(results);
    }
}

