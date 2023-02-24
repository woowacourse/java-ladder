package domain.mission;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Missions {
    private final List<Mission> missions;

    public Missions(List<String> missions, int size) {
        this.missions = formatMissions(missions);
        validateMissionsSize(size);
    }

    private void validateMissionsSize(int size) {
        if (size != this.missions.size()) {
            throw new IllegalArgumentException("참여자의 수와 미션의 수가 다릅니다!");
        }
    }

    private List<Mission> formatMissions(List<String> missions) {
        List<Mission> randomMission = missions.stream()
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
