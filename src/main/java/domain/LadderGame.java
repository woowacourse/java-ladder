package domain;

import dto.LadderDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(final Height height, final Width width, final LadderGenerator ladderGenerator) {
        this.ladder = new Ladder(height, width, ladderGenerator);
    }

    public Result play(final Users users, List<String> inputResults) {
        int startPosition = 0;
        Map<String, Integer> result = new HashMap<>();
        for (User user : users.getUsers()) {
            int finalPosition = startPosition;
            finalPosition = calculateFinalPosition(finalPosition);
            result.put(user.getName(), finalPosition);
            startPosition++;
        }
        return new Result(inputResults, result);
    }

    private int calculateFinalPosition(int finalPosition) {
        for (Line line : ladder.getLadder()) {
            final Direction nextDirection = line.calculateNextPosition(finalPosition);
            finalPosition += nextDirection.getDirectionWeight();
        }
        return finalPosition;
    }

    public LadderDTO getLadderDTO() {
        return ladder.getLadderDTO();
    }
}
