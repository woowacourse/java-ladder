package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final LadderResult result;

    public LadderGame(List<String> names, List<String> items, int height, LineStrategy lineStrategy) {
        validateNameItemSizeEquality(names, items);
        this.players = new Players(names);
        this.ladder = new Ladder(height, items);
        ladder.assignLines(lineStrategy, names.size() - 1);
        this.result = new LadderResult(makeLadderResult());
    }

    private void validateNameItemSizeEquality(List<String> names, List<String> items) {
        if (names.size() != items.size()) {
            throw new IllegalArgumentException("이름과 실행 결과의 개수가 맞지 않습니다.");
        }
    }

    private Map<Player, Item> makeLadderResult() {
        Map<Player, Item> result = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            Item item = ladder.getItemOfPlayer(player);
            result.put(player, item);
        }
        return result;
    }

    public List<List<Boolean>> getLines() {
        return ladder.getLines()
                .stream()
                .map(Line::getSteps)
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

    public List<String> getItems() {
        return ladder.getItems();
    }
}
