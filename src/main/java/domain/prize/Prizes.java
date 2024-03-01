package domain.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> rawPrizes) {
        return rawPrizes.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    public int findMaxPrizeNameLength() {
        return prizes.stream()
                .mapToInt(Prize::getNameLength)
                .max()
                .orElse(0);
    }

    public int count() {
        return prizes.size();
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    public List<String> getPrizes() {
        return prizes.stream()
                .map(Prize::getName)
                .toList();
    }
}
