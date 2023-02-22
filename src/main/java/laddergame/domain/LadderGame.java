package laddergame.domain;

import laddergame.constant.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;

    public LadderGame(Players players, Ladder ladder, Prizes prizes) {
        validatePlayerPrizeSize(players, prizes);
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    private void validatePlayerPrizeSize(Players playersInput, Prizes prizesInput) {
        if (playersInput.size() != prizesInput.size()) {
            throw new IllegalArgumentException(ErrorCode.PRIZE_COUNT_NOT_MATCHED.getCode());
        }
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public List<Line> getLadderMap() {
        return ladder.getLadder();
    }

    public List<String> getPrizeValues() {
        return prizes.getPrizeValues();
    }

    public GameResult getResult(String name) {
        Position startPosition = players.positionOf(name);
        Position endPosition = ladder.getArrivalPosition(startPosition);
        String prizeValue = prizes.getPrizeValueAt(endPosition);

        return new GameResult(name, prizeValue);
    }

    public List<GameResult> getAllResults() {
        List<GameResult> results = new ArrayList<>();
        for (String playerName : players.getPlayerNames()) {
            results.add(getResult(playerName));
        }
        return List.copyOf(results);
    }
}
