package dto;

import domain.ladder.LadderPrize;
import domain.player.Player;

public class GameResultDto {

    private final String playerName;
    private final String prize;

    private GameResultDto(String playerName, String prize) {
        this.playerName = playerName;
        this.prize = prize;
    }

    public static GameResultDto of(Player player, LadderPrize ladderPrize) {
        return new GameResultDto(player.getName(), ladderPrize.getPrize());
    }

    public String getPlayerName() {
        return playerName;
    }


    public String getPrize() {
        return prize;
    }
}
