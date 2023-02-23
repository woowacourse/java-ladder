package ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prizes {
    private final Map<Position, Prize> prizes;

    private Prizes(Map<Position, Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> prizeNames) {
        Map<Position, Prize> prizes = new HashMap<>();
        for (int i = 0; i < prizeNames.size(); i++) {
            Name prizeName = new Name(prizeNames.get(i));
            Position prizePosition = new Position(i);
            Prize prize = new Prize(prizeName);

            prizes.put(prizePosition, prize);
        }
        return new Prizes(prizes);
    }

    public Prize get(Position position) {
        return prizes.get(position);
    }
}
