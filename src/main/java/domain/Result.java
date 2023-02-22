package domain;

import domain.mission.Mission;
import domain.player.Player;

public class Result {

    private final String name;
    private final String mission;

    public Result(Player player, Mission mission) {
        this.name = player.getName().getName();
        this.mission = mission.getMission();
    }

    public String getName() {
        return name;
    }

    public String getMission() {
        return mission;
    }
}
