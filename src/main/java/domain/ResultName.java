package domain;

import java.util.List;

public class ResultName extends Name {

    public ResultName(String inputName, Players players) {
        super(inputName);
        validateName(inputName, players);
    }

    private void validateName(String inputName, Players players) {
        List<String> names = players.getPlayers().stream()
                .map(Name::getName)
                .toList();
        if (!names.contains(inputName) && !inputName.equals("all")) {
            throw new IllegalArgumentException("이름은 이전에 입력한 이름 중에 하나여야 합니다.");
        }
    }
}
