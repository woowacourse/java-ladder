package laddergame.domain.prize;

import laddergame.domain.player.Name;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Results {

    private static final String FIND_ALL_KEYWORD = "all";

    private final List<Result> results;

    public Results(final Players players, final Prizes prizes) {
        this.results = createResults(players, prizes);
    }

    private List<Result> createResults(final Players players, final Prizes prizes) {
        final List<Result> results = new ArrayList<>();

        for (int i = 0; i < players.getPlayerSize(); i++) {
            final Player player = players.getPlayers().get(i);
            final Result result = new Result(player, prizes.getPrize(player.getPosition()));
            results.add(result);
        }

        return results;
    }

    public List<Result> findResults(final Name name) {
        if (isSearchAllResults(name)) {
            return findAll();
        }

        return List.of(findIndividualResultByName(name));
    }

    private boolean isSearchAllResults(final Name name) {
        return FIND_ALL_KEYWORD.equals(name.getName());
    }

    private Result findIndividualResultByName(final Name name) {
        return results.stream()
                .filter(result -> result.equalsName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 이름의 플레이어가 없습니다."));
    }

    private List<Result> findAll() {
        return Collections.unmodifiableList(results);
    }
}
