package domain.mission;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Missions {
    private static final String SPLIT_STANDARD = ",";
    private final List<Mission> missions;

    public Missions(String missions, int size) {
        this.missions = formatMissions(missions);
        validateMissionsSize(size);
    }

    private void validateMissionsSize(int size) {
        if (size != this.missions.size()) {
            throw new IllegalArgumentException("참여자의 수와 미션의 수가 다릅니다!");
        }
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
