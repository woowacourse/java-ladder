package ladder.dto;

public class ResultRequest {

    public static final ResultRequest ALL = new ResultRequest(null, true);

    private final String playerName;
    private final boolean isRequestAll;

    private ResultRequest(String playerName, boolean isRequestAll) {
        this.playerName = playerName;
        this.isRequestAll = isRequestAll;
    }

    public ResultRequest(String playerName) {
        this(playerName, false);
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isRequestAll() {
        return isRequestAll;
    }
}
