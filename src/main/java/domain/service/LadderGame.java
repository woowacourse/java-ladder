package domain.service;

import domain.model.Ladder;
import domain.model.Players;
import domain.vo.Results;
import dto.ViewResultParameter;
import view.Command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGame {

    private static final String NO_PLAYER_ERROR_MESSAGE = "해당 플레이어는 존재하지 않습니다.";

    private final Ladder ladder;
    private final Players players;
    private final Results results;

    public LadderGame(Ladder ladder, Players players, Results results) {
        this.ladder = ladder;
        this.players = players;
        this.results = results;
    }

    public void play() {
        for (int i = 0; i < ladder.getHeight(); i++) {
            players.moveAll(ladder);
        }
    }

    public ViewResultParameter viewersAndResults(List<String> viewers) {
        if (viewers.contains(Command.QUIT.getName())) {
            return ViewResultParameter.of(Collections.emptyList(), Collections.emptyList());
        }
        if (viewers.contains(Command.ALL.getName())) {
            return ViewResultParameter.of(players.nameToString(), results.mapToString());
        }

        if (!players.containsAll(viewers)) {
            throw new IllegalArgumentException(NO_PLAYER_ERROR_MESSAGE);
        }

        List<String> orderedResults = orderResultsByName(viewers);
        return ViewResultParameter.of(viewers, orderedResults);
    }

    private List<String> orderResultsByName(List<String> viewersName) {
        List<String> orderedResults = new ArrayList<>();
        for (String viewer : viewersName) {
            int order = players.orderByName(viewer);
            orderedResults.add(results.get(order).getValue());
        }
        return orderedResults;
    }

    public Players getPlayers() {
        return players;
    }
}
