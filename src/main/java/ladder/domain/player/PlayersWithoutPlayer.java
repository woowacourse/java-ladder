package ladder.domain.player;

import ladder.domain.ladder.Ladder;
import ladder.domain.laddergame.Position;
import ladder.domain.reward.Rewards;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class PlayersWithoutPlayer {
    /**
     * Players이 일급컬렉션으로 List<Player>이 아닌,
     * Map<PlayerName, Position>을 가진 경우를 나타낸 클래스 입니다.
     * Players객체와 동일한 기능을 수행합니다.
     */

    public static final String DUPLICATED_PLAYERS_ERROR = "플레이어의 이름이 중복됩니다.";
    private static final int MINIMUM_COUNT_OF_PLAYERS = 2;
    private static final int MAXIMUM_COUNT_OF_PLAYERS = 10;
    public static final String NUMBER_OF_PLAYERS_ERROR = String.format("플레이어의 수는 %d명 이상 %d명 이하여야 합니다.",
            MINIMUM_COUNT_OF_PLAYERS, MAXIMUM_COUNT_OF_PLAYERS);


    private final Map<PlayerName, Position> players;

    PlayersWithoutPlayer(final List<String> playerNames) {
        validateDuplicatedNames(playerNames);
        validateNumberOfPlayers(playerNames);

        players = createPlayers(playerNames);
    }

    private static void validateDuplicatedNames(final List<String> players) {
        final int numberOfNotDuplicatedPlayers = Set.copyOf(players)
                .size();

        if (numberOfNotDuplicatedPlayers != players.size()) {
            throw new IllegalArgumentException(DUPLICATED_PLAYERS_ERROR);
        }
    }

    private Map<PlayerName, Position> createPlayers(final List<String> playerNames) {
        final Map<PlayerName, Position> playersAndPosition = new LinkedHashMap<>();

        IntStream.range(0, playerNames.size())
                .forEach(i ->
                        playersAndPosition.put(new PlayerName(playerNames.get(i)), new Position(i))
                );
        return playersAndPosition;
    }

    private void validateNumberOfPlayers(final List<String> players) {
        if (players.size() < MINIMUM_COUNT_OF_PLAYERS || players.size() > MAXIMUM_COUNT_OF_PLAYERS) {
            throw new IllegalArgumentException(NUMBER_OF_PLAYERS_ERROR);
        }
    }

    public void movePlayers(final Ladder ladder) {
        players.forEach((playerName, position) ->
                players.replace(playerName, ladder.findEndPositionOf(position)));
    }

    public Map<String, String> findResultOfPlayersWith(final Rewards rewards) {
        final Map<String, String> result = new LinkedHashMap<>();
        players.forEach((player, playerPosition) ->
                result.put(player.getName(), rewards.findRewardBy(playerPosition)
                        .getName()));

        return result;
    }

    public List<String> findPlayerNames() {
        return players.keySet()
                .stream()
                .map(PlayerName::getName)
                .collect(Collectors.toList());
    }
}
