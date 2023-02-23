package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Users users;
    private final Results results;
    private final LadderGameResult ladderGameResult;
    private boolean inProgress;

    public LadderGame(final Ladder ladder, final Users users, final Results results) {
        this.ladder = ladder;
        this.users = users;
        this.results = results;
        ladderGameResult = getLadderGameResult(users.getSize(), ladder.getLadderRows().size());
    }

    private LadderGameResult getLadderGameResult(final int userCount, final int ladderHeight) {
        Map<User, Result> map = new HashMap<>();
        for (int i = 0; i < userCount; i++) {
            User user = users.getUsers().get(i);
            int arrivalIndex = move(i, 0, ladderHeight);
            Result result = results.getResults().get(arrivalIndex);
            map.put(user, result);
        }
        return new LadderGameResult(map);
    }

    private int move(final int index, final int currentHeight, final int ladderHeight) {
        if (currentHeight == ladderHeight) {
            return index;
        }
        int existingLineIndex = getExistingLineIndex(index, currentHeight);
        if (isRight(index, existingLineIndex)) {
            return move(index + 1, currentHeight + 1, ladderHeight);
        }
        if (isLeft(index, existingLineIndex)) {
            return move(index - 1, currentHeight + 1, ladderHeight);
        }
        return move(index, currentHeight + 1, ladderHeight);
    }

    private int getExistingLineIndex(final int index, final int currentHeight) {
        List<LadderRow> ladderRows = ladder.getLadderRows();
        LadderRow ladderRow = ladderRows.get(currentHeight);
        return ladderRow.getExistingLineIndex(index);
    }

    private boolean isRight(final int index, final int existingLineIndex) {
        return index == existingLineIndex;
    }

    private boolean isLeft(final int index, final int existingLineIndex) {
        return index == existingLineIndex + 1;
    }

    public void play() {
        inProgress = true;
    }

    public LadderGameResult getLadderGameResultByName(final String name) {
        if (name.equals("all")) {
            inProgress = false;
            return ladderGameResult;
        }
        User user = users.findByName(name);
        Result result = ladderGameResult.findByUser(user);
        return new LadderGameResult(user, result);
    }

    public boolean inProgress() {
        return inProgress;
    }
}
