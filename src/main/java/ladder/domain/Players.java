package ladder.domain;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    private static final int MINIMUM_PLAYER_SIZE = 2;
    private static final int MAXIMUM_PLAYER_SIZE = 10;
    private static final String PLAYER_SIZE_ERROR_MESSAGE =
            "플레이어는 "
                    + MINIMUM_PLAYER_SIZE + "명 이상, "
                    + MAXIMUM_PLAYER_SIZE + "명 이하만 가능합니다. 현재 입력한 플레이어 수는 {0}명 입니다.";
    private static final String DUPLICATE_PLAYER_ERROR_MESSAGE = "플레이어 이름은 중복되면 안됩니다.";
    private static final String PLAYERS_IN_SAME_POSITION_MESSAGE = "같은 위치에 존재하는 플레이어가 있습니다.";
    private static final String PLAYER_NOT_FOUND_MESSAGE = "존재하지 않는 참여자 입니다.";

    private final List<Player> players;

    public Players(final List<String> names) {
        this(names, IntStream.range(0, names.size()).boxed().collect(Collectors.toList()));
    }

    public Players(final List<String> names, final List<Integer> positions) {
        final List<Player> generatePlayers = getGeneratePlayers(names, positions);
        validate(positions, generatePlayers);
        this.players = generatePlayers;
    }

    private List<Player> getGeneratePlayers(List<String> names, List<Integer> positions) {
        List<Player> generatePlayers = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            generatePlayers.add(new Player(names.get(i), positions.get(i)));
        }

        return generatePlayers;
    }

    private void validate(List<Integer> positions, List<Player> players) {
        playerValidate(players);
        positionValidate(positions);
    }

    private void playerValidate(List<Player> players) {
        validatePlayerSize(players);
        validateDuplicatePlayer(players);
    }

    private void positionValidate(List<Integer> positions) {
        HashSet<Integer> uniquePositions = new HashSet<>(positions);

        if (isDuplicate(positions, uniquePositions)) {
            throw new IllegalArgumentException(PLAYERS_IN_SAME_POSITION_MESSAGE);
        }
    }

    private void validatePlayerSize(final List<Player> players) {
        if (isSmallSize(players) || isLargeSize(players)) {
            throw new IllegalArgumentException(MessageFormat.format(PLAYER_SIZE_ERROR_MESSAGE, players.size()));
        }
    }

    private boolean isSmallSize(final List<Player> players) {
        return MINIMUM_PLAYER_SIZE > players.size();
    }

    private boolean isLargeSize(final List<Player> players) {
        return MAXIMUM_PLAYER_SIZE < players.size();
    }

    private void validateDuplicatePlayer(final List<Player> players) {
        final Set<Player> uniquePlayers = new HashSet<>(players);

        if (isDuplicate(players, uniquePlayers)) {
            throw new IllegalArgumentException(DUPLICATE_PLAYER_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicate(final List<?> data, final Set<?> uniqueData) {
        return data.size() != uniqueData.size();
    }

    public List<String> getPlayerNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getPositions() {
        return players.stream()
                .map(Player::getPosition)
                .collect(Collectors.toUnmodifiableList());
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public int findPositionByName(final String value) {
        return players.stream()
                .filter(player -> player.getName().equals(value))
                .map(Player::getPosition)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(PLAYER_NOT_FOUND_MESSAGE));
    }

    public Players move(Line line) {
        List<Integer> positions = this.getPositions();
        List<Direction> directions = line.getDirections();

        for (int i = 0; i < players.size(); i++) {
            int playerIndex = positions.get(i);
            Direction direction = directions.get(i);

            Player player = players.get(playerIndex);
            player.move(direction);
        }

        return this;
    }
}
