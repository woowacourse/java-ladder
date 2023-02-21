package domain;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final Users users;

    public LadderGame(final Ladder ladder, final Users users) {
        this.ladder = ladder;
        this.users = users;
    }

    public int move(int index, int currentHeight, int ladderHeight) {
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
}
