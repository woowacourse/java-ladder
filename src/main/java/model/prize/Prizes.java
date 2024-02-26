package model.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;
import model.player.Players;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> prizeNames, Players players) {
        return prizeNames.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), Prizes::new));
    }
}
