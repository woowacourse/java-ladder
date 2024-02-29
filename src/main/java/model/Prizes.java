package model;

import exception.Message;
import java.util.List;

public class Prizes {

    private final List<Prize> prizeValues;

    private Prizes(final List<Prize> prizeValues) {
        this.prizeValues = prizeValues;
    }

    public static Prizes of(final List<String> values, final int personCount) {
        validate(values, personCount);
        List<Prize> prizes = values.stream()
                .map(Prize::new)
                .toList();
        return new Prizes(prizes);
    }

    private static void validate(final List<String> values, final int personCount) {
        if (values.size() != personCount) {
            throw new IllegalArgumentException(Message.INVALID_RESULT_ERROR.getValue());
        }
    }

    public List<Prize> getPrizeValues() {
        return prizeValues;
    }

    public List<String> getPrizeNames() {
        return prizeValues.stream()
                .map(Prize::value)
                .toList();
    }
}
