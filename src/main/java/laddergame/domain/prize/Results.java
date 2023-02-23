package laddergame.domain.prize;

import laddergame.domain.player.Name;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(final Players players, final Prizes prizes) {
        this.results = createResults(players, prizes);
    }

    private static List<Result> createResults(final Players players, final Prizes prizes) {
        final List<Result> results = new ArrayList<>();

        for (int i = 0; i < players.getPlayerSize(); i++) {
            final Player player = players.getPlayers().get(i);
            final Result result = new Result(player, prizes.getPrize(player.getPosition()));
            results.add(result);
        }

        return results;
    }

    public List<Result> findResults(final Name name) {
        final String playerName = name.getName();
        if ("all".equals(playerName)) {
            return findAll();
        }

        return List.of(findIndividualResultByName(playerName));
    }

    public Result findIndividualResultByName(final String name) {
        return results.stream()
                .filter(result -> result.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("개인 결과 조회를 할 수 없습니다."));
    }

    public List<Result> findAll() {
        return results;
    }
}
