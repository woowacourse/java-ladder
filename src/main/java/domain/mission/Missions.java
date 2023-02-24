package domain.mission;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Missions {
    private final List<Mission> missions;

    public Missions(List<String> missions) {
        this.missions = formatMissions(missions);
    }

    private List<Mission> formatMissions(List<String> missions) {
        List<Mission> randomMission = missions.stream()
                .map(String::trim)
                .map(Mission::new)
                .collect(Collectors.toList());
        // TODO: shuffle에 대해서 통제할 수 있는 코드 작성
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
