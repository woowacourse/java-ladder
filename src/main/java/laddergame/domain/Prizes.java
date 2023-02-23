package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<String> values) {
        List<Prize> prizes = values.stream()
                .map(value -> new Prize(value))
                .collect(Collectors.toList());
        this.prizes = List.copyOf(prizes);
    }
}
