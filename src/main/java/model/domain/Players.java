package model.domain;

import model.vo.Name;
import model.vo.Position;
import model.vo.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private static final String NO_PLAYER_NAME_ERROR = "[ERROR] 해당 이름의 플레이어는 존재하지 않습니다.";
    private static final String NO_PLAYER_AT_POSITION_ERROR = "[ERROR] 해당 포지션의 플레이어는 존재하지 않습니다.";
    private final List<Player> players = new ArrayList<>();

    public Players(List<Name> names) {
        IntStream.range(0, names.size())
                .mapToObj(index -> new Player(names.get(index), new Position(index)))
                .forEach(players::add);
    }

    public int size() {
        return players.size();
    }

    public List<Name> getAllPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public List<Name> getAllNamesOrderedByPosition() {
        return IntStream.range(0, players.size())
                .mapToObj(index -> findNameBy(new Position(index)))
                .collect(Collectors.toList());
    }

    public void moveAllPlayersByLinePoints(List<Boolean> points) {
        IntStream.range(0, points.size())
                .forEach(index -> changePlayerPositionsAtPoint(index, points.get(index)));
    }

    public void saveAllResults(List<Result> results) {
        List<Player> playersOrderedByPosition = findPlayersOrderedByPosition();
        IntStream.range(0, results.size())
                .forEach(index -> saveResult(playersOrderedByPosition.get(index), results.get(index)));
    }

    public Result getResultOf(Name name) {
        return players.stream()
                .filter(player -> player.isSameName(name))
                .map(Player::getResult)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_PLAYER_NAME_ERROR));
    }

    private void saveResult(Player player, Result result) {
        player.saveResult(result);
    }

    private List<Player> findPlayersOrderedByPosition() {
        return IntStream.range(0, players.size())
                .mapToObj(Position::new)
                .map(this::findPlayerBy)
                .collect(Collectors.toList());
    }

    private void changePlayerPositionsAtPoint(int index, boolean point) {
        if (point) {
            findPlayerBy(new Position(index)).changePositionWith(findPlayerBy(new Position(index + 1)));
        }
    }

    private Name findNameBy(Position position) {
        return players.stream()
                .filter(player -> player.isSamePosition(position))
                .map(Player::getName)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_PLAYER_AT_POSITION_ERROR));
    }

    private Player findPlayerBy(Position position) {
        return players.stream()
                .filter(player -> player.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_PLAYER_AT_POSITION_ERROR));
    }
}
