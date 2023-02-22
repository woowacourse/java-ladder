package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Users users;
    private final Results results;
    private final LadderGameResult ladderGameResult;

    public LadderGame(final Ladder ladder, final Users users, final Results results) {
        this.ladder = ladder;
        this.users = users;
        this.results = results;
        ladderGameResult = getLadderGameResult(users.getSize(), ladder.getLadderRows().size());
    }

    private LadderGameResult getLadderGameResult(int userCount, int ladderHeight) {
        Map<User, Result> map = new HashMap<>();
        for (int i = 0; i < userCount; i++) {
            User user = users.getUsers().get(i);
            int arrivalIndex = move(i, 0, ladderHeight);
            Result result = results.getResults().get(arrivalIndex);
            map.put(user, result);
        }
        return new LadderGameResult(map);
    }

    public Result findResultByName(String name) {
        User user = users.findByName(name);
        return ladderGameResult.findByUser(user);
    }

    private int move(int index, int currentHeight, int ladderHeight) {
        if (currentHeight == ladderHeight) {
            return index;
        }
        List<LadderRow> ladderRows = ladder.getLadderRows();
        LadderRow ladderRow = ladderRows.get(currentHeight);
        int existingLineIndex = ladderRow.getExistingLineIndex(index);
        if (index == existingLineIndex) {
            return move(index + 1, currentHeight + 1, ladderHeight);
        }
        if (index == existingLineIndex + 1) {
            return move(index - 1, currentHeight + 1, ladderHeight);
        }
        return move(index, currentHeight + 1, ladderHeight);
    }

    public LadderGameResult getLadderGameResult() {
        return ladderGameResult;
    }
}
