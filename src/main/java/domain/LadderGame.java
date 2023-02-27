package domain;

import dto.LadderDTO;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final Users users;

    public LadderGame(final Height height, final Users users, final LadderGenerator ladderGenerator) {
        this.users = users;
        this.ladder = ladderGenerator.generate(users.getCount() - 1, height);
    }

    public Result play(WinningResults winningResults) {
        int startPosition = 0;
        Map<String, Integer> gameResult = new HashMap<>();
        for (User user : users.getUsers()) {
            int finalPosition = calculateFinalPosition(startPosition);
            gameResult.put(user.getName(), finalPosition);
            startPosition++;
        }
        return Result.of(winningResults, gameResult);
    }

    private int calculateFinalPosition(final int startPosition) {
        int finalPosition = startPosition;
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
