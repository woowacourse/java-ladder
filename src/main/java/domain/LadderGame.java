package domain;

import domain.ladder.Ladder;
import domain.mission.Mission;
import domain.mission.Missions;
import domain.player.Player;
import domain.player.Players;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final List<Result> result;

    private LadderGame(Players players, Missions missions, Ladder ladder) {
        this.result = getResults(players, missions, ladder);
    }

    private List<Result> getResults(Players players, Missions missions, Ladder ladder) {
        List<Player> playersSortedByPosition = moveAllPlayers(players, ladder);
        List<Mission> missionsSortedRandomly = getMissions(missions);

        return IntStream.range(0, missions.size())
                .mapToObj(index -> new Result(playersSortedByPosition.get(index), missionsSortedRandomly.get(index)))
                .collect(Collectors.toList());
    }

    public static LadderGame of(Players players, Missions missions, Ladder ladder) {
        return new LadderGame(players, missions, ladder);
    }

    private List<Mission> getMissions(Missions missions) {
        return new ArrayList<>(missions.getMissions());
    }

    private List<Player> moveAllPlayers(Players players, Ladder ladder) {
        players.moveAllPlayers(ladder);
        return players.getPlayersSortedByPosition();
    }

    public Result findResultByName(String name) {
        return result.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("해당 이름을 찾을 수 없습니다."));
    }

    public List<Result> findAllResult() {
        return Collections.unmodifiableList(result);
    }
}
