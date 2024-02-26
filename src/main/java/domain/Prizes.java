package domain;

import java.util.List;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public int getPrizeCount() {
        return prizes.size();
    }

    public String getPrize(int index) {
        return prizes.get(index).getPrize();
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
