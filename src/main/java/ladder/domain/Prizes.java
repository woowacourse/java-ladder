package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    public Prizes(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(final List<String> names) {
        return new Prizes(generatePrizes(names));
    }

    private static List<Prize> generatePrizes(final List<String> names) {
        return names.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public String check(final int position) {
        return prizes.get(position).getValue();
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getValue)
                .collect(Collectors.toList());
    }

    public int size() {
        return prizes.size();
    }
}
