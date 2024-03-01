package domain.result;

import domain.user.Users;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(final List<String> resultNames) {
        this.results = resultNames.stream().map(Result::new).toList();
    }


    public void validateSameSizeWithUsers(final Users users) {
        if (results.size() != users.size()) {
            throw new IllegalArgumentException("플레이어와 결과의 길이가 다릅니다");
        }
    }


}
