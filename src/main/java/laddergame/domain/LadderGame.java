package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import laddergame.domain.ladder.GameResult;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.line.LineWidth;
import laddergame.domain.players.Player;
import laddergame.domain.players.Players;
import laddergame.domain.util.ExceptionMessageFormatter;

public class LadderGame {

    private final Players players;
    private Ladder ladder;

    public LadderGame(List<String> names) {
        validatePlayerCount(names.size());
        List<Player> players = names.stream()
                .map(Player::new)
                .collect(Collectors.toList());
        this.players = new Players(players);
    }

    private static void validatePlayerCount(int playerCount) {
        if (playerCount < Players.MIN_PLAYER_COUNT) {
            String message = String.format("참여자가 %d명 이상이어야 사다리를 만들 수 있습니다.", Players.MIN_PLAYER_COUNT);
            throw new IllegalArgumentException(ExceptionMessageFormatter.format(message, playerCount));
        }
    }

    public void generateLadder(int height, List<String> results) {
        this.ladder = Ladder.of(new LineWidth(players.size()), new LadderHeight(height), results);
    }

    public GameResult computeResult() {
        validateLadderStatus();
        return new GameResult(findAllResultsByPlayer());
    }

    private void validateLadderStatus() {
        if (ladder == null) {
            throw new IllegalStateException("아직 사다리가 생성되지 않은 게임입니다.");
        }
    }

    private Map<String, String> findAllResultsByPlayer() {
        Map<String, String> allResults = new LinkedHashMap<>();
        players.getNames()
                .forEach(name -> allResults.put(name, findResultByPlayerName(name)));
        return allResults;
    }

    private String findResultByPlayerName(String playerName) {
        int startIndex = players.indexOf(playerName);
        return ladder.findResultByStartIndex(startIndex);
    }

    public List<String> playerNames() {
        return players.getNames();
    }

    public Ladder ladder() {
        validateLadderStatus();
        return ladder;
    }
}
