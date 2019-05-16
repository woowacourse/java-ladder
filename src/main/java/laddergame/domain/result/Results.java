package laddergame.domain.result;

import laddergame.domain.Constant;

import java.util.List;
import java.util.Objects;

public class Results {
    private List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Results)) return false;
        Results results1 = (Results) o;
        return Objects.equals(results, results1.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Result result : results) {
            stringBuilder.append(String.format("%-" + Constant.BOUND_OF_NAME_LENGTH + "s", result));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public Result getResult(int index) {
        return this.results.get(index);
    }
}
