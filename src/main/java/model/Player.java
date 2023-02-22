package model;

import util.ExceptionMessage;

public class Player {
    private static final String END_MESSAGE = "all";

    private final String player;

    public Player(Names names, String player) {
        validatePlayer(names, player);
        this.player = player;
    }

    private void validatePlayer(Names names, String player) {
        if (!(names.getNames().contains(new Name(player)) || player.equals(END_MESSAGE))) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_PLAYER_RESULT.getExceptionMessage());
        }
    }

    public boolean isExistPlayer(Player name) {
        return !player.equals(END_MESSAGE) && player.equals(name.getPlayer());
    }

    public boolean isEqualEndMessage(Player player) {
        return player.getPlayer().equals(END_MESSAGE);
    }

    public String getPlayer() {
        return this.player;
    }

}
