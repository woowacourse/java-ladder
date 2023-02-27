package domain;

import domain.ladder.Ladder;
import domain.mission.Mission;
import domain.mission.Missions;
import domain.player.Name;
import domain.player.Names;
import domain.player.Position;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Names names;
    private final Missions missions;
    private final Ladder ladder;

    private LadderGame(Names names, Missions missions, Ladder ladder) {
        this.names = names;
        this.missions = missions;
        this.ladder = ladder;
    }

    public static LadderGame of(Names names, Missions missions, Ladder ladder) {
        return new LadderGame(names, missions, ladder);
    }

    public Result findResultBy(String value) {
        Name name = names.findByName(value);
        return findResultByName(name);
    }

    public List<Result> findAllResult() {
        List<Result> result = new ArrayList<>();
        for (Name name : names.getNames()) {
            result.add(findResultByName(name));
        }
        return result;
    }

    private Result findResultByName(Name name) {
        Position initialPosition = names.initialPositionOf(name);
        Position finalPosition = ladder.findFinalPosition(initialPosition);
        Mission mission = missions.findByPosition(finalPosition);
        return new Result(name, mission);
    }
}
