package dto;

public class GameResultDto {

    private final String playerName;
    private final String prize;

    public GameResultDto(String playerName, String prize) {
        this.playerName = playerName;
        this.prize = prize;
    }

    public String getPlayerName() {
        return playerName;
    }


    public String getPrize() {
        return prize;
    }
}
