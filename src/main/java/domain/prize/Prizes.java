package domain.prize;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public List<String> getPrizeNames() {
        List<String> prizeNames = new ArrayList<>();
        for (Prize prize : prizes) {
            prizeNames.add(prize.getPrizeName());
        }
        return prizeNames;
    }
}
