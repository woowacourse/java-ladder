package domain;

import domain.mission.Mission;
import domain.player.Name;

public class Result {

    private final String name;
    private final String mission;

    public Result(Name name, Mission mission) {
        this.name = name.getValue();
        this.mission = mission.getMission();
    }

    public String getName() {
        return name;
    }

    public String getMission() {
        return mission;
    }
}
