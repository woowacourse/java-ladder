package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Bets {
    private final List<Bet> bets;

    public Bets(List<String> bets) {
        this.bets = bets.stream()
                .map(Bet::new)
                .collect(Collectors.toList());
    }

    public List<Bet> getBets() {
        return Collections.unmodifiableList(bets);
    }

    public int size() {
        return bets.size();
    }
}
