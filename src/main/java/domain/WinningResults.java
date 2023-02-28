package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningResults {
    private final List<WinningResult> winningResults;

    public WinningResults(final List<WinningResult> winningResults) {
        this.winningResults = winningResults;
    }

    public WinningResult findByDestinationPosition(final int index) {
        return winningResults.get(index);
    }

    public List<WinningResult> getWinningResults() {
        return new ArrayList<>(winningResults);
    }
}
