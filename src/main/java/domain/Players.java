package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private static final String DUPLICATE_NAME_MESSAGE = "중복된 이름입니다.";

    private final List<Person> players = new ArrayList<>();

    public Players(List<String> names) {
        validateDuplicateName(names);
        initiatePlayers(names);
    }

    public List<String> getPlayersName() {
        return players.stream()
                .map(s -> s.getName())
                .collect(Collectors.toList());
    }

    public int getCount() {
        return players.size();
    }

    private void validateDuplicateName(List<String> names) {
        if (isDuplicated(names)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MESSAGE);
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
