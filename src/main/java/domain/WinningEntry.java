package domain;

import exception.ErrorCode;
import java.util.List;

public class WinningEntry {
    private final List<String> winningEntry;

    public WinningEntry(List<String> winningEntry, int personCount) {
        validate(winningEntry, personCount);
        this.winningEntry = winningEntry;
    }

    private void validate(List<String> winningEntry, int personCount) {
        if (winningEntry.size() != personCount) {
            throw new IllegalArgumentException(ErrorCode.WRONG_WINNING_ENTRY_SIZE.getMessage());
        }
    }

    public List<String> getWinningEntry() {
        return winningEntry;
    }

    public String findByPosition(int position) {
        return winningEntry.get(position);
    }
}
