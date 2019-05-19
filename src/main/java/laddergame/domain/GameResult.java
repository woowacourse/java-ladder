package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<String> results = new ArrayList<>();
    private Request request;

    public GameResult(String request, Players players, Prizes prizes) {
        Request wrappedRequest = new Request(players, request);
        this.request = wrappedRequest;

        for (int i = 0; i < players.getPlayers().size(); i++) {
            results.add(players.getPlayers().get(i) + " : " + prizes.getPrizes().get(i) + "\n");
        }
    }

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

}
