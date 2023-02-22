package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Missions {
    private final List<Mission> missions;
    private static final String SPLIT_STANDARD = ",";

    public Missions(String missions) {
        this.missions = new ArrayList<>();
        for (String mission : missions.split(SPLIT_STANDARD)) {
            this.missions.add(new Mission(mission.trim()));
        }
    }

    public Mission getMissionByIndex(int index) {
        return missions.get(index);
    }

    public List<Mission> getMissions() {
        return Collections.unmodifiableList(missions);
    }


    public int size() {
        return missions.size();
    }
}
