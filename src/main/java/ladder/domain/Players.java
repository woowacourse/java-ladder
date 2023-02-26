package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_COUNT_OF_PLAYERS = 2;
    private static final int MAXIMUM_COUNT_OF_PLAYERS = 10;
    private final List<Player> players;

    private Players(final List<Player> players) {
        validateDuplicatedNames(players);
        validateNumberOfPlayers(players);
        this.players = players;
    }

    public static Players from(final List<String> playerNames) {
        List<Player> players = playerNames.stream()
                .map(inputName -> new Player(new PlayerName(inputName)))
                .collect(Collectors.toList());

        return new Players(players);
    }

    public int findNumberOfAllPlayers() {
        return players.size();
    }

    public List<String> findNameOfAllPlayers() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    private void validateDuplicatedNames(final List<Player> players) {
        int numberOfNotDuplicatedPlayers = Set.copyOf(players).size();

        if (numberOfNotDuplicatedPlayers != players.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_PLAYERS_ERROR.message);
        }
    }

    private void validateNumberOfPlayers(final List<Player> players) {
        if (players.size() < MINIMUM_COUNT_OF_PLAYERS || players.size() > MAXIMUM_COUNT_OF_PLAYERS) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_PLAYERS_ERROR.message);
        }
    }

    public void rewardPlayer(final int index, final Reward reward) {
        players.get(index).determineReward(reward);
    }

    public Map<String, String> findRewardsOfPlayers() {
        Map<String, String> result = new HashMap<>();
        players.forEach(player ->
                result.put(player.getName(), player.getReward()));

        return result;
    }

    public Map<String, String> findRewardOfPlayerBy(final String playerName) {
        Map<String, String> result = new HashMap<>();
        players.stream()
                .filter(player -> player.getName().equals(playerName))
                .forEach(player ->
                        result.put(player.getName(), player.getReward()));

        return result;
    }


    private enum ErrorMessage {
        DUPLICATED_PLAYERS_ERROR("플레이어의 이름이 중복됩니다."),
        NUMBER_OF_PLAYERS_ERROR("플레이어의 수는 %d명 이상 %d명 이하여야 합니다.", MINIMUM_COUNT_OF_PLAYERS, MAXIMUM_COUNT_OF_PLAYERS);
        private final String message;

        ErrorMessage(String message, Object... replace) {
            this.message = String.format(message, replace);
        }
    }

}
