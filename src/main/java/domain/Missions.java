package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Missions {
    private final List<Mission> missions;
    private static final String SPLIT_STANDARD = ",";

    public Missions(String missions) {
        System.out.println(missions);
        this.missions = formatMissions(missions);
        System.out.println(formatMissions(missions));
    }

    private List<Mission> formatMissions(String missions) {
        List<Mission> randomMission = Arrays.stream(missions.split(SPLIT_STANDARD))
                .map(String::trim)
                .map(Mission::new)
                .collect(Collectors.toList());
        Collections.shuffle(randomMission);
        return randomMission;
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
