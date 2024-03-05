package domain.ladder;

import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ladder {
    private final List<Floor> floors;

    private Ladder(List<Floor> floors) {
        this.floors = floors;
    }

    public static Ladder create(Height height, Players players, BooleanGenerator booleanGenerator) {
        List<Floor> floors = new ArrayList<>();
        for (int count = 0; count < height.getValue(); count++) {
            Floor floor = Floor.create(players.count(), booleanGenerator);
            floors.add(floor);
        }
        return new Ladder(floors);
    }

    public LadderResult climb(Players players, Prizes prizes) {
        Map<Player, Prize> result = new LinkedHashMap<>();
        for (int start = 0; start < players.count(); start++) {
            int end = climbFloors(start);
            result.put(players.findPlayerByIndex(start), prizes.findPrizeByIndex(end));
        }
        return new LadderResult(result);
    }

    private int climbFloors(int index) {
        for (Floor floor : floors) {
            index = floor.crossConnection(index);
        }
        return index;
    }

    public List<Floor> getFloors() {
        return Collections.unmodifiableList(floors);
    }
}
