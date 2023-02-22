package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {


    private LadderGame(Players players, Missions missions, Lines lines) {
        players.getPlayers().forEach(player -> player.move(lines));
        List<Player> finalLocationOfPlayer = players.getPlayers().stream()
                .sorted(Comparator.comparing(player -> player.getPosition().getPosition()))
                .collect(Collectors.toList());
        System.out.println(finalLocationOfPlayer);

        List<Mission> finalLocationOfMission = new ArrayList<>(missions.getMissions());
        Collections.shuffle(finalLocationOfMission);
        System.out.println(finalLocationOfMission);

        Map<Player, Mission> finalResult = new HashMap<>();
        for (int index = 0; index < finalLocationOfPlayer.size(); index++) {
            finalResult.put(finalLocationOfPlayer.get(index), finalLocationOfMission.get(index));
        }
        System.out.println(finalResult);
    }

    public static LadderGame of(Players players, Missions missions, Lines lines) {
        return new LadderGame(players, missions, lines);
    }
}
