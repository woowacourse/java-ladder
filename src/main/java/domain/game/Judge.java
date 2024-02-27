package domain.game;

import domain.db.Name;
import domain.db.Names;
import domain.db.Prize;
import domain.db.Prizes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Judge {
    private static final String SEARCH_ALL_KEY_WORD = "all";
    private final Names players;
    private final Prizes prizes;
    private final PathMapper pathMapper;

    public Judge(final Names players, final Prizes prizes, final PathMapper pathMapper) {
        this.players = players;
        this.prizes = prizes;
        this.pathMapper = pathMapper;
    }

    public Map<Name, Prize> search(final String name) throws IllegalArgumentException {
        final List<Name> targets = getTargets(name);
        return getResult(targets);
    }

    private List<Name> getTargets(final String name) {
        if (Objects.equals(name, SEARCH_ALL_KEY_WORD)) {
            return players.names();
        }
        return List.of(new Name(name));
    }

    private Map<Name, Prize> getResult(final List<Name> targets) {
        return targets.stream().collect(Collectors.toMap(
                player -> player,
                player -> getPrize(player.name()),
                (a, b) -> a,
                LinkedHashMap::new
        ));
    }

    private Prize getPrize(final String name) {
        final int departure = getDeparture(name);
        try {
            final int arrival = this.pathMapper.find(departure);
            return this.prizes.prizes().get(arrival);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        }
    }

    private int getDeparture(final String name) {
        final int departure = this.players.getSequence(name);
        if (departure == -1) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }
        return departure;
    }
}
