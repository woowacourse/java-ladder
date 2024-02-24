package model;

import java.util.List;

public class Result {

    private final List<Prize> prizes;

    private Result(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Result from(final List<String> values) {
        List<Prize> prizes = values.stream()
                .map(Prize::new)
                .toList();
        return new Result(prizes);
    }

}
