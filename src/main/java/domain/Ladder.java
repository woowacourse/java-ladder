package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(final Height height, final Width width, final LadderGenerator randomLadderGenerator) {
        this.ladder = randomLadderGenerator.generate(width, height);
    }

    public Map<String, Integer> play(final Users users) {
        int startPosition = 0;
        Map<String, Integer> result = new HashMap<>();
        for (User user : users.getUsers()) {
            int finalPosition = startPosition;
            finalPosition = calculateFinalPosition(finalPosition);
            result.put(user.getName(), finalPosition);
            startPosition++;
        }
        return result;
    }

    private int calculateFinalPosition(int finalPosition) {
        for (Line line : ladder) {
            final Direction nextDirection = line.calculateNextPosition(finalPosition);
            finalPosition += nextDirection.getDirectionWeight();
        }
        return finalPosition;
    }

    public List<Line> getLadder() {
        return new ArrayList<>(ladder);
    }
}
