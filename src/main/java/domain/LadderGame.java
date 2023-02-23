package domain;

import domain.ladder.Lines;
import domain.mission.Mission;
import domain.mission.Missions;
import domain.player.Player;
import domain.player.Players;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final List<Result> result;

    private LadderGame(Players players, Missions missions, Lines lines) {
        this.result = getResults(players, missions, lines);
    }

    private List<Result> getResults(Players players, Missions missions, Lines lines) {
        List<Player> playersSortedByPosition = moveAllPlayers(players, lines);
        List<Mission> missionsSortedRandomly = getMissions(missions);

        return IntStream.range(0, missions.size())
                .mapToObj(index -> new Result(playersSortedByPosition.get(index), missionsSortedRandomly.get(index)))
                .collect(Collectors.toList());
    }

    public static LadderGame of(Players players, Missions missions, Lines lines) {
        return new LadderGame(players, missions, lines);
    }

    private static ArrayList<Mission> getMissions(Missions missions) {
        return new ArrayList<>(missions.getMissions());
    }

    private List<Player> moveAllPlayers(Players players, Lines lines) {
        players.moveAllPlayers(lines);
        return players.getPlayersSortedByPosition();
    }

    public Result findResultByName(String name) {
        return result.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 찾을 수 없습니다."));
    }

    public List<Result> findAllResult() {
        return Collections.unmodifiableList(result);
    }
}
