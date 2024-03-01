package domain.game;

import domain.ladder.LineNumber;

public class GameResult {
    private final String description;
    private final LineNumber lineNumber;

    public GameResult(final String description, final LineNumber lineNumber) {
        this.description = description;
        this.lineNumber = lineNumber;
    }

    public static GameResult of(final String gameResultDescription, final int lineNumber) {
        return new GameResult(gameResultDescription, new LineNumber(lineNumber));
    }

    public String getDescription() {
        return description;
    }

    public boolean isEqualLineNumber(final LineNumber lineNumber) {
        return this.lineNumber.isEqual(lineNumber.value());
    }
}
