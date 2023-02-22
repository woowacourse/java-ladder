package domain;

import exception.ErrorCode;
import java.util.ArrayList;
import java.util.List;

public class WinningEntry {
    private final List<WinningResult> winningEntry;

    public WinningEntry(List<WinningResult> winningEntry, int personCount) {
        validate(winningEntry, personCount);
        this.winningEntry = winningEntry;
    }

    private void validate(List<WinningResult> winningEntry, int personCount) {
        if (winningEntry.size() != personCount) {
            throw new IllegalArgumentException(ErrorCode.WRONG_WINNING_ENTRY_SIZE.getMessage());
        }
    }

    public List<WinningResult> getWinningEntry() {
        return new ArrayList<>(winningEntry);
    }

    public String findResultByPosition(int position) {
        return winningEntry.get(position).getResult();
    }
}
