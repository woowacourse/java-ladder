package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<String> prizeValues) {
        this.prizes = prizeValues.stream()
                .map(value -> new Prize(value))
                .collect(Collectors.toUnmodifiableList());
    }

    public String getPrizeValueAt(Position position) {
        int index = position.getValue() - 1;
        return prizes.get(index).getValue();
    }

    public int size() {
        return prizes.size();
    }

    public List<String> getPrizeValues() {
        return prizes.stream()
                .map(prize -> prize.getValue())
                .collect(Collectors.toUnmodifiableList());
    }
}
