package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final int MIN_NUMBER_OF_PLAYERS = 2;
    private static final int MAX_NUMBER_OF_PLAYERS = 100;
    private static final String DUPLICATE_NAME_MESSAGE = "중복된 이름입니다.";
    private static final String INVALID_NUMBER_OF_PLAYER_MESSAGE = "참여자 수는 %d부터 %d까지 입니다.";

    private final List<Person> players = new ArrayList<>();

    public Players(List<String> names) {
        validateDuplicateNames(names);
        validateNumberOfPlayer(names);
        initiatePlayers(names);
    }

    public List<String> getNames() {
        return players.stream()
                .map(s -> s.getName())
                .collect(Collectors.toList());
    }

    public int getCount() {
        return players.size();
    }

    private void validateDuplicateNames(List<String> names) {
        if (isDuplicated(names)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MESSAGE);
        }
    }

    private void validateNumberOfPlayer(List<String> names) {
        if (names.size() < MIN_NUMBER_OF_PLAYERS || names.size() > MAX_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NUMBER_OF_PLAYER_MESSAGE, MIN_NUMBER_OF_PLAYERS, MAX_NUMBER_OF_PLAYERS));
        }
    }

    private boolean isDuplicated(List<String> names) {
        return names.size() != names.stream().distinct().count();
    }

    private void initiatePlayers(List<String> names) {
        for (String name : names) {
            players.add(new Person(name));
        }
    }

}
