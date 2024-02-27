package domain.game;

import domain.db.Player;
import domain.db.Players;
import domain.db.Prize;
import domain.db.Prizes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Judge {
    private static final String SEARCH_ALL_KEY_WORD = "all";
    private final Players players;
    private final Prizes prizes;
    private final PathMapper pathMapper;

    public Judge(final Players players, final Prizes prizes, final PathMapper pathMapper) {
        this.players = players;
        this.prizes = prizes;
        this.pathMapper = pathMapper;
    }

    public Map<Player, Prize> search(final String name) throws IllegalArgumentException {
        final List<Player> targets = getTargets(name);
        return getResult(targets);
    }

    private List<Player> getTargets(final String name) {
        if (Objects.equals(name, SEARCH_ALL_KEY_WORD)) {
            return players.players();
        }
        return List.of(new Player(name));
    }

    private Map<Player, Prize> getResult(final List<Player> targets) {
        return targets.stream().collect(Collectors.toMap(
                player -> player,
                player -> getPrize(player.name()),
                (a, b) -> a,
                LinkedHashMap::new
        ));
    }

    private Prize getPrize(final String name) {
        try {
            final int departure = this.players.getSequence(name);
            final int arrival = this.pathMapper.find(departure);
            return this.prizes.getPrize(arrival);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }
    }
}
