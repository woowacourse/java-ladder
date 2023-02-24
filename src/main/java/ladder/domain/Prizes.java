package ladder.domain;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private static final String PRIZES_SIZE_ERROR_MESSAGE = "상품의 개수는 %d이어야합니다.";
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    private Prizes(List<Prize> prizes, int expectedSize) {
        validateSize(prizes, expectedSize);
        this.prizes = prizes;
    }

    public static Prizes from(List<String> names, int expectedSize) {
        List<Prize> prizes = names.stream().map(Prize::new).collect(Collectors.toList());
        return new Prizes(prizes, expectedSize);
    }

    private void validateSize(List<Prize> prizes, int expectedSize) {
        if (prizes.size() != expectedSize) {
            throw new IllegalArgumentException(String.format(PRIZES_SIZE_ERROR_MESSAGE, expectedSize));
        }
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

    public List<String> getNames() {
        return prizes.stream()
                .map(Prize::getName)
                .collect(toUnmodifiableList());
    }
}
