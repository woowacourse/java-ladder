package domain;

import domain.mission.Mission;
import domain.player.Player;

public class Result {

    private final Player player;
    private final Mission mission;

    public Result(Player player, Mission mission) {
        this.player = player;
        this.mission = mission;
    }

    public String getName() {
        return player.getName().getName();
    }

    public String getMission() {
        return mission.getMission();
    }
}
