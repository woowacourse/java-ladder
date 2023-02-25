package laddergame.model;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> prizes) {
        return new Prizes(prizes.stream().map(Prize::new).collect(Collectors.toList()));
    }
}
