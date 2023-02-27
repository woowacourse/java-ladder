package ladder.domain.ladder;

import ladder.domain.player.Player;
import ladder.domain.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    private final Height height;
    private final Rewards rewards;

    public Ladder(int height, List<String> rewards) {
        this.height = new Height(height);
        this.lines = new ArrayList<>();
        this.rewards = new Rewards(rewards);
    }

    public void assignLines(LineStrategy lineStrategy, int sectionCount) {
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(new Line(lineStrategy, sectionCount));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Reward getItemOfPlayer(Player player) {
        Position nextPosition = player.getStartPosition();
        for (Line line : lines) {
            nextPosition = line.findNextPosition(nextPosition);
        }
        return findSamePositionItem(nextPosition);
    }

    private Reward findSamePositionItem(Position position) {
        return rewards.findItem(position);
    }

    public List<String> getRewards() {
        return rewards.getRewards();
    }
}
