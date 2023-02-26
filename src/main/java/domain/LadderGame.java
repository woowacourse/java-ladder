package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Ladder ladder;
    private final Users users;
    private final Rewards rewards;
    private LadderGameResult ladderGameResult;
    private boolean inProgress;

    public LadderGame(final Ladder ladder, final Users users, final Rewards rewards) {
        this.ladder = ladder;
        this.users = users;
        this.rewards = rewards;
        inProgress = false;
    }

    public void play() {
        inProgress = true;
        Map<User, Reward> result = new HashMap<>();
        for (int departureIndex = 0; departureIndex < users.getSize(); departureIndex++) {
            int arrivalIndex = move(departureIndex, 0, ladder.getLadderHeight());
            User user = users.getUsers().get(departureIndex);
            Reward reward = rewards.getRewards().get(arrivalIndex);
            result.put(user, reward);
        }
        ladderGameResult = new LadderGameResult(result);
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

    public LadderGameResult getLadderGameResultByName(final String name) {
        if (name.equals("all")) {
            inProgress = false;
            return ladderGameResult;
        }
        User user = users.findByName(name);
        Reward reward = ladderGameResult.findByUser(user);
        return new LadderGameResult(user, reward);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Users getUsers() {
        return users;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public boolean isInProgress() {
        return inProgress;
    }
}
