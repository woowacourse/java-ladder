package domain.ladder;

import static domain.ladder.DirectionalPoint.LEFT;
import static domain.ladder.DirectionalPoint.RIGHT;
import static domain.ladder.DirectionalPoint.STRAIGHT;
import static domain.ladder.DirectionalPoint.findDirectionalPoint;

import domain.booleanGenerator.BooleanGenerator;
import domain.player.Player;
import domain.player.Players;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<DirectionalPoint> ladderPoints;

    public LadderRow(BooleanGenerator booleanGenerator, int maximumSize) {
        ladderPoints = new ArrayList<>();
        for (int i = 0; i < maximumSize; i++) {
            DirectionalPoint ladderPoint = determineNextPoint(booleanGenerator, getLastPoint(), i, maximumSize);
            ladderPoints.add(ladderPoint);
        }
    }

    public void playRow(Players players) {
        for (int i = 0; i < ladderPoints.size(); i++) {
            Player player = players.findPlayerByIndex(i);
            player.move(ladderPoints.get(player.getPosition()));
        }
    }

    private DirectionalPoint determineNextPoint(final BooleanGenerator booleanGenerator,
                                                final DirectionalPoint lastPoint,
                                                final int currentIndex, final int maximumSize) {
        if (lastPoint == RIGHT) {
            return LEFT;
        }
        if (currentIndex == maximumSize - 1) {
            return STRAIGHT;
        }
        return findDirectionalPoint(booleanGenerator.generate());
    }

    private DirectionalPoint getLastPoint() {
        if (!ladderPoints.isEmpty()) {
            return ladderPoints.get(ladderPoints.size() - 1);
        }
        return STRAIGHT;
    }

    public List<DirectionalPoint> getLadderPoints() {
        return Collections.unmodifiableList(this.ladderPoints);
    }
}
