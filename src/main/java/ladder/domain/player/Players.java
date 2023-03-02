package ladder.domain.player;

import ladder.domain.ladder.Ladder;
import ladder.domain.laddergame.Position;
import ladder.domain.reward.RewardName;
import ladder.domain.reward.Rewards;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Players {

    private static final int MINIMUM_COUNT_OF_PLAYERS = 2;
    private static final int MAXIMUM_COUNT_OF_PLAYERS = 10;

    private final Map<Player, Position> players;

    public Players(final List<String> playerNames) {
        validateDuplicatedNames(playerNames);
        validateNumberOfPlayers(playerNames);

        players = createPlayers(playerNames);
    }

    private static void validateDuplicatedNames(final List<String> players) {
        final int numberOfNotDuplicatedPlayers = Set.copyOf(players)
                .size();

        if (numberOfNotDuplicatedPlayers != players.size()) {
            throw new IllegalArgumentException(Players.ErrorMessage.DUPLICATED_PLAYERS_ERROR.message);
        }
    }

    private void validateNumberOfPlayers(final List<String> players) {
        if (players.size() < MINIMUM_COUNT_OF_PLAYERS || players.size() > MAXIMUM_COUNT_OF_PLAYERS) {
            throw new IllegalArgumentException(Players.ErrorMessage.NUMBER_OF_PLAYERS_ERROR.message);
        }
    }

    private Map<Player, Position> createPlayers(final List<String> playerNames) {
        final Map<Player, Position> players = new LinkedHashMap<>();

        IntStream.range(0, playerNames.size())
                .forEach(i -> {
                    final Position position = new Position(i);
                    players.put(new Player(new PlayerName(playerNames.get(i)), position), position);
                });

        return players;
    }

    public void movePlayers(final Ladder ladder) {
        players.keySet()
                .forEach(player -> players.replace(player, player.traceThePath(ladder)));
    }

    public Map<PlayerName, RewardName> findResultOfPlayersWith(final Rewards rewards) {

        final Map<PlayerName, RewardName> result = new LinkedHashMap<>();

        players.forEach((player, playerPosition) ->
                result.put(player.getName(), rewards.findRewardBy(playerPosition)));

        return result;
    }

    public List<String> findPlayerNames() {
        final List<String> playerNames = new ArrayList<>();
        players.forEach((player, position) ->
                playerNames.add(player.getName()
                        .getName()));

        return playerNames;
    }

    public int findNumberOfPlayers() {
        return players.size();
    }


    private enum ErrorMessage {
        DUPLICATED_PLAYERS_ERROR("플레이어의 이름이 중복됩니다."),
        NUMBER_OF_PLAYERS_ERROR("플레이어의 수는 %d명 이상 %d명 이하여야 합니다.", MINIMUM_COUNT_OF_PLAYERS, MAXIMUM_COUNT_OF_PLAYERS);
        private final String message;

        ErrorMessage(final String message, final Object... replace) {
            this.message = String.format(message, replace);
        }
    }


    //방법2 List<SecondPlayer> players

//    private final List<SecondPlayer> players;
//
//    private SecondPlayers(final List<SecondPlayer> players) {
//        validateDuplicatedNames(players);
//        validateNumberOfPlayers(players);
//        this.players = players;
//    }
//
//    public static SecondPlayers from(final List<String> playerNames) {
//
//        return new SecondPlayers(
//                IntStream.range(0, playerNames.size())
//                        .mapToObj(index -> new SecondPlayer(new PlayerName(playerNames.get(index)), new SecondPosition(index)))
//                        .collect(Collectors.toList())
//        );
//    }
//
//    private static void validateDuplicatedNames(final List<SecondPlayer> players) {
//        int numberOfNotDuplicatedPlayers = Set.copyOf(players).size();
//
//        if (numberOfNotDuplicatedPlayers != players.size()) {
//            throw new IllegalArgumentException(SecondPlayers.ErrorMessage.DUPLICATED_PLAYERS_ERROR.message);
//        }
//    }
//
//    private void validateNumberOfPlayers(final List<SecondPlayer> players) {
//        if (players.size() < MINIMUM_COUNT_OF_PLAYERS || players.size() > MAXIMUM_COUNT_OF_PLAYERS) {
//            throw new IllegalArgumentException(SecondPlayers.ErrorMessage.NUMBER_OF_PLAYERS_ERROR.message);
//        }
//    }
//
//
//    public Map<SecondPlayer, SecondPosition> movePlayers(SecondLadder ladder) {
//        Map<SecondPlayer, SecondPosition> result = new LinkedHashMap<>();
//
//        players.forEach(player -> {
//            SecondPosition endPosition = player.traceThePath(ladder);
//            result.put(player, endPosition);
//        });
//
//        return result;
//    }
//
//    public Map<PlayerName, RewardName> findResultOfPlayersWith(SecondRewards rewards) {
//        Map<PlayerName, RewardName> result = new LinkedHashMap<>();
//
//        players.forEach(player -> {
//            RewardName rewardName = rewards.findRewardBy(player.getPosition());
//            result.put(player.getName(), rewardName);
//        });
//
//        return result;
//    }
//
//    public List<String> findPlayerNames() {
//        return players.stream()
//                .map(player -> player.getName().getName())
//                .collect(Collectors.toList());
//    }


}
