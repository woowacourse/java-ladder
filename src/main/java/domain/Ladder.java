package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<Line> ladder;

    public Ladder(Height height, Width width, LadderGenerator randomLadderGenerator) {
        this.ladder = randomLadderGenerator.generate(width, height);
    }

    public Map<String, Integer> play(Users users) {
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
            finalPosition = line.calculateNextPosition(finalPosition);
        }
        return finalPosition;
    }

    public List<Line> getLadder() {
        return new ArrayList<>(ladder);
    }
}
