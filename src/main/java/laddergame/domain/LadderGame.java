package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.line.Line;
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
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.format("참여자가 " + Players.MIN_PLAYER_COUNT + "명 이상이어야 사다리를 만들 수 있습니다.",
                            playerCount));
        }
    }

    public List<Line> generateLadder(int height, List<String> results) {
        ladder = Ladder.of(new LineWidth(players.size()), new LadderHeight(height), results);
        return ladder.toLines();
    }

    public String findResultByPlayerName(String playerName) {
        int startIndex = players.indexOf(playerName);
        if (ladder == null) {
            throw new IllegalStateException("사다리가 생성되지 않은 게임의 결과를 확인할 수 없습니다.");
        }
        return ladder.findResultByStartIndex(startIndex);
    }

    public Map<String, String> findAllResultsByPlayer() {
        Map<String, String> allResults = new LinkedHashMap<>();
        players.getNames()
                .forEach(name -> allResults.put(name, findResultByPlayerName(name)));
        return allResults;
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }
}
