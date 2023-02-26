package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import laddergame.domain.ladder.GameResult;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.destination.Item;
import laddergame.domain.ladder.line.LineWidth;
import laddergame.domain.players.Players;

public class LadderGame {

    private final Players players;
    private Ladder ladder;

    public LadderGame(List<String> playerNames) {
        this.players = Players.of(playerNames);
    }

    public void generateLadder(int height, List<String> itemValues) {
        List<Item> items = itemValues.stream()
                .map(Item::new)
                .collect(Collectors.toList());
        this.ladder = Ladder.of(new LineWidth(players.size()), new LadderHeight(height), items);
    }

    public GameResult computeResult() {
        validateLadderStatus();
        return new GameResult(findItemsByPlayer());
    }

    private void validateLadderStatus() {
        if (ladder == null) {
            throw new IllegalStateException("아직 사다리가 생성되지 않은 게임입니다.");
        }
    }

    private Map<String, String> findItemsByPlayer() {
        Map<String, String> result = new LinkedHashMap<>();
        players.getNames()
                .forEach(name -> result.put(name, findItemByPlayerName(name)));
        return result;
    }

    private String findItemByPlayerName(String playerName) {
        int startIndex = players.indexOf(playerName);
        Item found = ladder.findItemsByStartIndex(startIndex);
        return found.getValue();
    }

    public List<String> playerNames() {
        return players.getNames();
    }

    public Ladder ladder() {
        validateLadderStatus();
        return ladder;
    }
}
