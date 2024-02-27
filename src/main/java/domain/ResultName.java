package domain;

import java.util.List;

public class ResultName extends Name {

    private final Players players;

    public ResultName(String inputName, Players players) {
        super(inputName);
        this.players = players;
        validateName(inputName);
    }

    private void validateName(String inputName) {
        List<String> names = players.getPlayers().stream()
                .map(Name::getName)
                .toList();
        if (!names.contains(inputName) && !inputName.equals("all")) {
            throw new IllegalArgumentException("이름은 이전에 입력한 이름 중에 하나여야 합니다.");
        }
    }
}
