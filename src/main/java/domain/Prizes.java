package domain;

import java.util.ArrayList;
import java.util.List;

public class Prizes {

    private final List<Prize> prizes = new ArrayList<>();

    public Prizes(final List<String> prizeNames) {
        for (final String prizeName : prizeNames) {
            prizes.add(new Prize(prizeName));
        }
    }

    //TODO: 나중에 position 을 Position으로 포장할지 고민
    public Prize getPrizeBy(final int position) {
        return prizes.get(position);
    }
}
