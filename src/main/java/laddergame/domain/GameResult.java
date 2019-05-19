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
            results.add(players.getPlayers().get(i).getName().getName() + " : " + prizes.getPrizes().get(i) + "\n");
        }
    }

    public boolean isRequestAll() {
        return this.request.getRequest().equals("all");
    }

    public List<String> getResults() {
        return results;
    }

    public int getResultsSize() {
        return results.size();
    }

    public boolean isMatch(int index) {
        return results.get(index).startsWith(request.getRequest() + " : ");
    }

}
