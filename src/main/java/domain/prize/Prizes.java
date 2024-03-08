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

    public int size() {
        return prizes.size();
    }

    public Prize getBy(int prizeIndex) {
        return prizes.get(prizeIndex);
    }

    public Prize findByIndex(int index) {
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return List.copyOf(prizes);
    }
}
