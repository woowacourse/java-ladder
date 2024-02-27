package ladder.domain;

public class GameResult {
    private final GameResultDescription gameResultDescription;
    private final LineNumber lineNumber;

    public GameResult(final GameResultDescription gameResultDescription, final LineNumber lineNumber) {
        this.gameResultDescription = gameResultDescription;
        this.lineNumber = lineNumber;
    }

    public static GameResult of(final String gameResultDescription, final int lineNumber) {
        return new GameResult(
                new GameResultDescription(gameResultDescription),
                new LineNumber(lineNumber)
        );
    }

    public String getGameResultDescriptionValue() {
        return gameResultDescription.value();
    }
}
