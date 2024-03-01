package domain.result;

import domain.user.Users;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(final List<String> resultNames) {
        this.results = resultNames.stream().map(Result::new).toList();
    }


    public void validateSameSizeWithUsers(final Users users) {
        if (results.size() != users.size()) {
            throw new IllegalArgumentException("플레이어와 결과의 수는 같아야합니다.");
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
