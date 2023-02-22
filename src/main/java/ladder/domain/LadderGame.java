package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final LadderResult result;

    public LadderGame(List<String> names, List<String> items, int height, LineStrategy lineStrategy) {
        this.players = new Players(names);
        this.ladder = new Ladder(height, items);
        ladder.assignLines(lineStrategy, names.size() - 1);
        this.result = new LadderResult(makeLadderResult());
    }

    private Map<Player, Item> makeLadderResult() {
        Map<Player, Item> result = new HashMap<>();
        for (Player player : players.getPlayers()) {
            Item item = ladder.getItemOfPlayer(player);
            result.put(player, item);
        }
        return result;
    }

    public List<List<Boolean>> getLines() {
        return ladder.getLines()
                .stream()
                .map(Line::getSections)
                .collect(Collectors.toList());
    }

    public int getNameMaxLength() {
        return players.getNameMaxLength();
    }

    public List<String> getPlayerNames() {
        return players.getPlayerNames();
    }

    public Map<String, String> getGameResult() {
        Map<Player, Item> gameResult = result.getResult();
        Map<String, String> result = new HashMap<>();
        for(Player player: gameResult.keySet()) {
            result.put(player.getName().getValue(), gameResult.get(player).getItem());
        }
        return result;
    }

    public String getPlayerResult(String playerName) {
        Player player = players.findPlayerByName(playerName);
        return result.getItemOfPlayer(player)
                .getItem();
    }
}
