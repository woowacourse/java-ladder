package domain;

import java.util.List;

public class ResultName{

    private static final String ALL = "all";
    private final Name name;

    public ResultName(String inputName, Players players) {
        this.name = new Name(inputName);
        validateName(inputName, players);
    }

    private void validateName(String inputName, Players players) {
        List<String> names = players.getPlayers().stream()
                .map(Name::getName)
                .toList();
        if (isNotAllowedResultName(inputName, names)) {
            throw new IllegalArgumentException("이름은 이전에 입력한 이름 중에 하나여야 합니다.");
        }
    }

    private boolean isNotAllowedResultName(String inputName, List<String> names) {
        return !names.contains(inputName) && !inputName.equals(ALL);
    }

    public Name getName() {
        return name;
    }
}
