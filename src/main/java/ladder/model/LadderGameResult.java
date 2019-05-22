package ladder.model;

public class LadderGameResult {
    private final String result;

    LadderGameResult(final String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return String.format("%-6s", result);
    }
}
