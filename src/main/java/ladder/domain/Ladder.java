package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public LadderResult makeResult(Players players, Items items) {
        Map<Player, Item> result = new HashMap<>();
        for (int i = 0; i < lines.get(0).getNumberOfPlayers(); i++) {
            Player player = players.getPlayer(i);
            result.put(player, play(i, items));
        }
        return new LadderResult(result);
    }

    private Item play(int index, Items items) {
        return items.getItem(getItemIndex(index));
    }

    private int getItemIndex(int index) {
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            index = moveIndex(line, index);
        }
        return index;
    }

    private int moveIndex(Line line, int index) {
        return line.getMovedIndex(index);
    }

    public Line getLine(int index) {
        return lines.get(index);
    }

    public int getHeight() {
        return lines.size();
    }

    public int getNumberOfPlayers() {
        return lines.get(0).getNumberOfPlayers();
    }
}
