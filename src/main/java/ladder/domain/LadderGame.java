package ladder.domain;

import java.util.List;
import java.util.Map;

public class LadderGame {
    private static final String PLAYERS_AND_PRIZES_SIZE_ERROR_MESSAGE = "플레이어수와 상품수는 동일해야 합니다.";
    private final Players players;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGame(Players players, Prizes prizes, Ladder ladder) {
        validatePlayersAndPrizesSize(players, prizes);
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    private void validatePlayersAndPrizesSize(Players players, Prizes prizes) {
        if (prizes.size() != players.size()) {
            throw new IllegalArgumentException(PLAYERS_AND_PRIZES_SIZE_ERROR_MESSAGE);
        }
    }

    public void run() {
        List<Integer> orders = ladder.getAllEndPosition();
        Prizes orderedPrizes = prizes.getOrderedPrizes(orders);
        players.setPrizes(orderedPrizes);
    }

    public String getPrizeNameByPlayerName(String playerName) {
        Player player = players.findByName(playerName);
        return player.getPrizeName();
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }

    public Map<String, String> getGameResult() {
        return players.getPrizesWithPlayers();
    }

    public List<String> getPrizeNames() {
        return prizes.getNames();
    }

    public List<Row> getLadder() {
        return ladder.getLadder();
    }
}
