package model;

import util.ExceptionMessage;

public class Player {
    private static final String END_MESSAGE = "all";

    private final String player;

    public Player(Names names, String player) {
        validatePlayer(names, player);
        this.player = player;
    }

    private boolean validatePlayer(Names names, String player){
        if(names.getNames().contains(new Name(player)) || player.equals(END_MESSAGE)){
            return true;
        }
        throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_PLAYER_RESULT.getExceptionMessage());
    }

    public boolean comparePlayer(Player name){
        if(player.equals(END_MESSAGE)){
            return false;
        }
        else if(player.equals(name.getPlayer())){
            return true;
        }
        return false;
    }

    public String getPlayer(){
        return this.player;
    }
}
