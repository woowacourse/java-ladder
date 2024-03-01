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

    // TODO: 호출하는 부분에서 예외를 어떻게 알게 하는가
    public Map<Player, Prize> search(final String name) throws IllegalArgumentException {
        final List<Player> targets = getTargets(name);
        return getResult(targets);
    }

    private List<Player> getTargets(final String name) {
        if (SEARCH_ALL_KEY_WORD.equals(name)) {
            return players.players();
        }
        return List.of(new Player(name));
    }

    private Map<Player, Prize> getResult(final List<Player> targets) {
        return targets.stream()
                .collect(Collectors.toMap(
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
