package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final Height height;
    private final Items items;

    public Ladder(int height, List<String> items) {
        this.height = new Height(height);
        this.lines = new ArrayList<>();
        this.items = new Items(items);
    }

    public void assignLines(LineStrategy lineStrategy, int sectionCount) {
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(lineStrategy, sectionCount));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Item getItemOfPlayer(Player player) {
        Position nextPosition = player.getStartPosition();
        for (Line line : lines) {
            nextPosition = line.findNextPosition(nextPosition);
        }
        return findSamePositionItem(nextPosition);
    }

    private Item findSamePositionItem(Position position) {
        return items.findItem(position);
    }

    public List<String> getItems() {
        return items.getItems();
    }
}
