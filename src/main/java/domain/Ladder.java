package domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int playerCount, Height height, BooleanGenerator booleanGenerator){
        List<Line> lines = new ArrayList<>();
        while (height.isRemain()) {
            lines.add(new Line(playerCount, booleanGenerator));
            height.decrease();
        }
        return new Ladder(lines);
    }

    public Map<Integer, List<Boolean>> getLinesInformation() {
        Map<Integer, List<Boolean>> information = new LinkedHashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            information.put(i + 1, lines.get(i).getBridgesInformation());
        }
        return information;
    }

    public Map<Player, Prize> getResult(Players players, Prizes prizes){
        Map<Player, Prize> result = new LinkedHashMap<>();
        for (int i = 0; i < players.getSize(); i++) {
            result.put(players.get(i), prizes.get(getDestinationIndex(i)));
        }
        return result;
    }

    private int getDestinationIndex(int start) {
        int position = start;
        for (Line line : lines) {
            position = line.getNextPosition(position);
        }
        return position;
    }
}
