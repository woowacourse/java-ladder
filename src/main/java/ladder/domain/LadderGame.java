package ladder.domain;

import ladder.domain.ladder.Reward;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.ladder.LineStrategy;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final LadderResult result;

    public LadderGame(List<String> names, List<String> rewards, int height, LineStrategy lineStrategy) {
        validateNameItemSizeNotEquality(names, rewards);
        this.players = new Players(names);
        this.ladder = new Ladder(height, rewards);
        ladder.assignLines(lineStrategy, names.size() - 1);
        this.result = new LadderResult(makeLadderResult());
    }

    private void validateNameItemSizeNotEquality(List<String> names, List<String> rewards) {
        if (names.size() != rewards.size()) {
            throw new IllegalArgumentException("이름과 실행 결과의 개수가 맞지 않습니다.");
        }
    }

    private Map<Player, Reward> makeLadderResult() {
        Map<Player, Reward> result = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            Reward reward = ladder.getItemOfPlayer(player);
            result.put(player, reward);
        }
        return result;
    }

    public List<List<Boolean>> getLines() {
        return ladder.getLines()
                .stream()
                .map(Line::getSteps)
                .collect(Collectors.toList());
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public Map<String, String> getGameResult() {
        Map<Player, Reward> gameResult = result.getResult();
        Map<String, String> result = new LinkedHashMap<>();
        for (Player player : gameResult.keySet()) {
            result.put(player.getName().getValue(), gameResult.get(player).getName());
        }
        return result;
    }

    public String getPlayerResult(String playerName) {
        Player player = players.findPlayerByName(playerName);
        return result.getItemOfPlayer(player)
                .getName();
    }

    public List<String> getRewards() {
        return ladder.getRewards();
    }
}


