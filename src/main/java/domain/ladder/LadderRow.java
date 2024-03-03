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

    public LadderRow(BooleanGenerator booleanGenerator, int rowSize) {
        ladderPoints = new ArrayList<>();
        for (int currentIndex = 0; currentIndex < rowSize; currentIndex++) {
            boolean isTheLastPoint = currentIndex == rowSize - 1;
            DirectionalPoint ladderPoint = determineNextPoint(booleanGenerator, getLastPoint(), isTheLastPoint);
            ladderPoints.add(ladderPoint);
        }
    }

    // TODO: Ladder - Players 결합도 낮추기
    public void playRow(Players players) {
        for (int i = 0; i < ladderPoints.size(); i++) {
            Player player = players.findPlayerByIndex(i);
            player.move(ladderPoints.get(player.getPosition()).getDirection());
        }
    }

    private DirectionalPoint determineNextPoint(final BooleanGenerator booleanGenerator,
                                                final DirectionalPoint lastPoint,
                                                final boolean isTheLastPoint) {
        if (lastPoint == RIGHT) {
            return LEFT;
        }
        if (isTheLastPoint) {
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
