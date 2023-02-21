package domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {
    private final List<Player> players;

    public Players(Names names) {
        this.players = names.getNames().stream()
                .map(name -> new Player(name, createPosition(names, name)))
                .collect(Collectors.toList());
    }

    private Position createPosition(Names names, Name name) {
        return new Position(names.getNames().indexOf(name));
    }

    public Player findByIndex(int index) {
        return players.get(index);
    }

    public Player findByName(String readPlayer) {
        return players.stream()
                .filter(player -> Objects.equals(player.getName(), new Name(readPlayer)))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 플레이어가 없습니다."));
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public void distributeMissions(Missions missions) {
        for (int index = 0; index < missions.getMissions().size(); index++) {
            int finalIndex = index;
            Player player = players.stream()
                    .filter(element -> element.getPosition().getPosition() == finalIndex)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("해당 index의 사용자가 존재하지 않습니다."));
            player.distributeMission(missions.getMissionByIndex(index));
        }
    }
}
