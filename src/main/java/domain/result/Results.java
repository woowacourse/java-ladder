package domain.result;

import domain.user.Users;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(final List<Result> results) {
        validate(results);
        this.results =results;
    }

    private void validate(final List<Result> results) {
        validateEmptiness(results);
    }

    private void validateEmptiness(final List<Result> results) {
        if(results == null || results.isEmpty()){
            throw new IllegalArgumentException("하나 이상의 결과가 있어야합니다.");
        }
    }

    public static Results fromNames(final List<String> resultNames) {
        return new Results(resultNames.stream().map(Result::new).toList());
    }


    public void validateSameSizeWithUsers(final Users users) {
        if (results.size() != users.size()) {
            throw new IllegalArgumentException("플레이어의 수와 결과의 수는 같아야합니다.");
        }
    }

    public Result get(final int index) {
        return results.get(index);
    }

    @Override
    public String toString() {
        return results.stream().map(Result::toString).collect(Collectors.joining(","));
    }

}
