package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Users users;
    private final Rewards rewards;
    private final LadderGameResult ladderGameResult;
    private boolean inProgress;

    public LadderGame(final Ladder ladder, final Users users, final Rewards rewards) {
        this.ladder = ladder;
        this.users = users;
        this.rewards = rewards;
        ladderGameResult = getLadderGameResult(users.getSize(), ladder.getLadderHeight());
    }

    private LadderGameResult getLadderGameResult(final int userCount, final int ladderHeight) {
        Map<User, Reward> map = new HashMap<>();
        for (int i = 0; i < userCount; i++) {
            User user = users.getUsers().get(i);
            int arrivalIndex = move(i, 0, ladderHeight);
            Reward reward = rewards.getRewards().get(arrivalIndex);
            map.put(user, reward);
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
        Reward reward = ladderGameResult.findByUser(user);
        return new LadderGameResult(user, reward);
    }

    public boolean inProgress() {
        return inProgress;
    }
}
