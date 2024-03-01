package domain.game;

import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    public Map<Player, Prize> search(final String name) {
        final List<Player> targets = getTargets(name);
        return makeResult(targets);
    }

    private List<Player> getTargets(final String name) {
        if (SEARCH_ALL_KEY_WORD.equals(name)) {
            return players.players();
        }

        final Player player = players.findByName(name).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        return List.of(player);
    }

    private Map<Player, Prize> makeResult(final List<Player> targets) {
        return targets.stream().collect(Collectors.toMap(
                player -> player,
                this::mapByPath,
                (a, b) -> a,
                LinkedHashMap::new
        ));
    }

    private Prize mapByPath(final Player player) {
        try {
            final int departure = this.players.getSequence(player);
            final int arrival = this.pathMapper.find(departure);
            return this.prizes.getByIndex(arrival);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }
    }
}
