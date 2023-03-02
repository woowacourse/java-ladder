package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_NUMBER_OF_PLAYERS = 2;
    private static final int MAX_NUMBER_OF_PLAYERS = 100;
    private static final String DUPLICATE_NAME_MESSAGE = "중복된 이름입니다.";
    private static final String INVALID_NUMBER_OF_PLAYER_MESSAGE = "참여자 수는 %d부터 %d까지 입니다.";
    private static final String PLAYER_NOT_EXIST_MESSAGE = "해당 참여자가 존재하지 않습니다.";

    private final List<Player> players = new ArrayList<>();

    public Players(List<String> names) {
        validateDuplicateNames(names);
        validateNumberOfPlayer(names);
        initiatePlayers(names);
    }

    private void validateDuplicateNames(List<String> names) {
        if (isDuplicated(names)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MESSAGE);
        }
    }

    private boolean isDuplicated(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    private void validateNumberOfPlayer(List<String> names) {
        if (names.size() < MIN_NUMBER_OF_PLAYERS || names.size() > MAX_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NUMBER_OF_PLAYER_MESSAGE, MIN_NUMBER_OF_PLAYERS, MAX_NUMBER_OF_PLAYERS));
        }
    }

    private void initiatePlayers(List<String> names) {
        for (String name : names) {
            players.add(new Player(name));
        }
    }

    public List<String> getNames() {
        return players.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int getOrder(String name) {
        int order = getNames().indexOf(name);
        if (order == -1) {
            throw new IllegalArgumentException(PLAYER_NOT_EXIST_MESSAGE);
        }
        return order;
    }

    public int getCount() {
        return players.size();
    }

}
