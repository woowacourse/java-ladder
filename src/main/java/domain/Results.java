package domain;

import java.util.List;

public class Results {

    List<Result> prizes;

    public Results(List<Result> prizes) {
        this.prizes = prizes;
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Result::toString)
                .toList();
    }

    public Result getFirst() {
        return prizes.get(0);
    }

    public Result getLast() {
        return prizes.get(prizes.size() - 1);
    }
    public List<Result> getMiddleResult() {
        return prizes.subList(1, prizes.size() - 1);
    }
}
