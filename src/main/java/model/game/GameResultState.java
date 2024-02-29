package model.game;

import model.player.Player;
import model.prize.Prize;

public record GameResultState(String playerName, String prizeName) {
    public static GameResultState from(Player player, Prize prize) {
        return new GameResultState(player.getName(), prize.getName());
    }
}
