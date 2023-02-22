package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGame {

    private final List<Result> result;
    private final Players players;
    private final Missions missions;

    private LadderGame(Players players, Missions missions, Lines lines) {
        this.players = players;
        this.missions = missions;
        List<Player> playersSortedByPosition = moveAllPlayers(players, lines);
        List<Mission> missionsSortedRandomly = getMissions(missions);

        List<Result> result = new ArrayList<>();
        for (int index = 0; index < playersSortedByPosition.size(); index++) {
            result.add(new Result(playersSortedByPosition.get(index), missionsSortedRandomly.get(index)));
        }
        this.result = result;
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
