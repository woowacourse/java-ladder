package model.ladder;

import model.player.Player;
import model.prize.Prize;

public record LadderPlayOutcomeState(String playerName, String prizeName) {
    public static LadderPlayOutcomeState from(Player player, Prize prize) {
        return new LadderPlayOutcomeState(player.getName(), prize.getName());
    }
}
