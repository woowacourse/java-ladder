package domain.result;

import domain.player.Player;
import domain.player.Players;
import java.util.HashMap;
import java.util.List;

public class Result {

    private static final String NO_SUCH_PLAYER_MESSAGE = "란, 플레이어는 없습니다.";

    private final HashMap<Player, Prize> result;

    public Result(final Players players, final Prizes prizes){
        this.result = createResult(players, prizes);
    }

    private HashMap<Player, Prize> createResult(final Players players, final Prizes prizes){
        HashMap<Player, Prize> result = new HashMap<>();
        List<Player> gamePlayers = players.getPlayers();

        for(int currentPlayerIndex = 0; currentPlayerIndex<gamePlayers.size(); currentPlayerIndex++){
            result.put(gamePlayers.get(currentPlayerIndex), prizes.query(currentPlayerIndex));
        }

        return result;
    }

    public Prize queryByPlayer(Player player){
        Prize prize = result.get(player);

        if(prize == null){
            throw new IllegalArgumentException(player.toString()+NO_SUCH_PLAYER_MESSAGE);
        }

        return prize;
    }
}
