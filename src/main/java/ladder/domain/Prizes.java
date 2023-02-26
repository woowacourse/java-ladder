package ladder.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes from(List<String> names) {
        return names.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toUnmodifiableList(), Prizes::new));
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    public Prizes getOrderedPrizes(List<Integer> orders) {
        List<Prize> orderedPrize = new ArrayList<>();
        for (int order : orders) {
            orderedPrize.add(get(order));
        }
        return new Prizes(orderedPrize);
    }

    public int size() {
        return prizes.size();
    }

    public List<String> getNames() {
        return prizes.stream()
                .map(Prize::getName)
                .collect(toUnmodifiableList());
    }
}
