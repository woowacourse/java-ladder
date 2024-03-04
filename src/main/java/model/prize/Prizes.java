package model.prize;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import exception.Message;
import java.util.List;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> names, int playersSize) {
        validate(names, playersSize);
        return names.stream()
                .map(Prize::new)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    private static void validate(List<String> prizes, int playersSize) {
        if (prizes.size() != playersSize) {
            throw new IllegalArgumentException(Message.INVALID_PRIZES_ERROR.getMessage());
        }
    }

    public Prize getPrizeByIndex(final int index) {
        return prizes.get(index);
    }

    public List<String> getPrizesName() {
        return prizes.stream()
                .map(Prize::getName)
                .toList();
    }
}
