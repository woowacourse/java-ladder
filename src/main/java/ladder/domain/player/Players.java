package ladder.domain.player;

import ladder.domain.ladder.Ladder;
import ladder.domain.laddergame.Position;
import ladder.domain.reward.RewardName;
import ladder.domain.reward.Rewards;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {

    public static final String DUPLICATED_PLAYERS_ERROR = "플레이어의 이름이 중복됩니다.";
    private static final int MINIMUM_COUNT_OF_PLAYERS = 2;
    private static final int MAXIMUM_COUNT_OF_PLAYERS = 10;
    public static final String NUMBER_OF_PLAYERS_ERROR = String.format("플레이어의 수는 %d명 이상 %d명 이하여야 합니다.",
            MINIMUM_COUNT_OF_PLAYERS, MAXIMUM_COUNT_OF_PLAYERS);


    private final List<Player> players;

    private Players(final List<Player> players) {
        validateDuplicatedNames(players);
        validateNumberOfPlayers(players);
        this.players = players;
    }

    public static Players from(final List<String> playerNames) {

        return new Players(
                IntStream.range(0, playerNames.size())
                        .mapToObj(index -> new Player(new PlayerName(playerNames.get(index)), new Position(index)))
                        .collect(Collectors.toList())
        );
    }

    private static void validateDuplicatedNames(final List<Player> players) {
        final int numberOfNotDuplicatedPlayers = Set.copyOf(players)
                .size();

        if (numberOfNotDuplicatedPlayers != players.size()) {
            throw new IllegalArgumentException(DUPLICATED_PLAYERS_ERROR);
        }
    }

    private void validateNumberOfPlayers(final List<Player> players) {
        if (players.size() < MINIMUM_COUNT_OF_PLAYERS || players.size() > MAXIMUM_COUNT_OF_PLAYERS) {
            throw new IllegalArgumentException(NUMBER_OF_PLAYERS_ERROR);
        }
    }

    public void movePlayers(final Ladder ladder) {
        players.forEach(player -> player.traceThePath(ladder));
    }

    public Map<PlayerName, RewardName> findResultOfPlayersWith(final Rewards rewards) {
        final Map<PlayerName, RewardName> result = new LinkedHashMap<>();

        players.forEach(player -> {
            final RewardName rewardName = rewards.findRewardBy(player.getPosition());
            result.put(player.getName(), rewardName);
        });

        return result;
    }

    public List<String> findPlayerNames() {
        return players.stream()
                .map(player -> player.getName()
                        .getName())
                .collect(Collectors.toList());
    }

    public int findNumberOfPlayers() {
        return players.size();
    }

}
