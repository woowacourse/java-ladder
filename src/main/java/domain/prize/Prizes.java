package domain.prize;

import java.util.List;

public class Prizes {

    List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> prizes) {
        return new Prizes(prizes.stream()
                .map(Prize::new)
                .toList());
    }

    public int getPrizeCount() {
        return prizes.size();
    }

    public Prize getOnePrizeByIndex(int prizeIndex) {
        return prizes.get(prizeIndex);
    }

    public List<Prize> getPrizes() {
        return List.copyOf(prizes);
    }
}
