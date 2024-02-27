package domain;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = prizes.stream()
                .map(Prize::new)
                .toList();
    }

    public int getSize() {
        return prizes.size();
    }
}
