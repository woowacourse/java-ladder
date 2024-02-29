package domain;

import java.util.List;

public class Prizes {

    private final List<PrizeName> prizeNames;

    public Prizes(List<PrizeName> prizeNames) {
        this.prizeNames = prizeNames;
    }

    public int getPrizeCount() {
        return prizeNames.size();
    }

    public String getPrize(int index) {
        return prizeNames.get(index).getPrize();
    }

    public List<PrizeName> getPrizes() {
        return prizeNames;
    }
}
