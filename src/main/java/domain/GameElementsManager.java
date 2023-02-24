package domain;

import domain.mission.Missions;
import domain.player.Names;

public class GameElementsManager {

    private final Names names;
    private final Missions missions;

    private GameElementsManager(Names names, Missions missions) {
        validateSize(names, missions);
        this.names = names;
        this.missions = missions;
    }

    public static GameElementsManager of(Names names, Missions missions) {
        return new GameElementsManager(names, missions);
    }

    private static void validateSize(Names names, Missions missions) {
        if (names.size() != missions.size()) {
            throw new IllegalArgumentException("사용자의 수와 실행 결과의 수는 같아야 합니다.");
        }
    }

    public Missions receiveMissions() {
        return missions;
    }
}
