package model;

import exception.Message;
import java.util.List;

public class Result {

    private final List<Prize> prizes;

    private Result(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Result of(final List<String> values, final int personCount) {
        List<Prize> prizes = values.stream()
                .map(Prize::new)
                .toList();
        validate(values, personCount);
        return new Result(prizes);
    }

    private static void validate(final List<String> values, final int personCount) {
        if (values.size() != personCount) {
            throw new IllegalArgumentException(Message.INVALID_RESULT_ERROR.getMessage());
        }
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
