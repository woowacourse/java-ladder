package domain.game;

import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;

import java.util.Collections;
import java.util.LinkedHashMap;
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
        if (SEARCH_ALL_KEY_WORD.equals(name)) {
            return makeResultAll();
        }

        final Player target = getTarget(name);
        return makeResult(target);
    }

    private Map<Player, Prize> makeResultAll() {
        return this.players.players().stream().collect(Collectors.toMap(
                player -> player,
                this::getPrizeMappedByLadder,
                (a, b) -> a,
                LinkedHashMap::new
        ));
    }

    private Player getTarget(final String name) {
        return this.players.findByName(name).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }

    private Map<Player, Prize> makeResult(final Player player) {
        return Collections.singletonMap(player, getPrizeMappedByLadder(player));
    }

    private Prize getPrizeMappedByLadder(final Player player) {
        try {
            final int departure = this.players.getSequence(player);
            final int arrival = this.pathMapper.findArrival(departure);
            return this.prizes.getByIndex(arrival);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }
    }
}
