package ladder.dto;

public class ResultRequestDto {

    public static final ResultRequestDto ALL = new ResultRequestDto(null, true);

    private final String playerName;
    private final boolean isRequestAll;

    private ResultRequestDto(String playerName, boolean isRequestAll) {
        this.playerName = playerName;
        this.isRequestAll = isRequestAll;
    }

    public ResultRequestDto(String playerName) {
        this(playerName, false);
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isRequestAll() {
        return isRequestAll;
    }
}
