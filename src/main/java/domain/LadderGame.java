package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {


    private LadderGame(Players players, Missions missions, Lines lines) {
        List<Player> playersSortedByPosition = moveAllPlayers(players, lines);
        List<Mission> finalMission = new ArrayList<>(missions.getMissions());
        
        Map<Player, Mission> finalResult = new HashMap<>();
        for (int index = 0; index < playersSortedByPosition.size(); index++) {
            finalResult.put(playersSortedByPosition.get(index), finalMission.get(index));
        }
    }

    private static List<Player> moveAllPlayers(Players players, Lines lines) {
        players.moveAllPlayers(lines);
        return players.getPlayersSortedByPosition();
    }

    public static LadderGame of(Players players, Missions missions, Lines lines) {
        return new LadderGame(players, missions, lines);
    }
}
