package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<String> results = new ArrayList<>();

    public String getResult(List<Player> players, String name) {
        validateExistedInputException(players, name);

        if (name.equals("all")) {
            return getAllResult();
        }
        return getRequestedResult(name);
    }

    private String getRequestedResult(String name) {
        int index = 0;

        while (index < results.size() && !results.get(index).startsWith(name + " : ")) {
            index++;
        }

        return results.get(index);
    }

    private String getAllResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String result : results) {
            stringBuilder.append(result);
        }
        return stringBuilder.toString();
    }

    public void makeResult(List<Player> players, List<Prize> prizes) {
        for (int i = 0; i < players.size(); i++) {
            results.add(players.get(i) + " : " + prizes.get(i) + "\n");
        }
    }

    private static void validateExistedInputException(List<Player> players, String input) {
        if (input.equals("all")) { return; }

        boolean isNamePresent = false;
        for (int i = 0; i < players.size() && !isNamePresent; i++) {
            isNamePresent = players.get(i).contains(input);
        }

        if (!isNamePresent) { throw new IllegalArgumentException("일치하는 플레이어의 이름이 존재하지 않습니다."); }
    }
}
