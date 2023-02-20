package domain;

import static utils.ErrorMessage.INVALID_RESULT_SIZE;

import java.util.List;

public class Results {

    private final List<String> results;

    public Results(List<String> results, int userCount) {
        validateResultSize(results, userCount);
        this.results = results;
    }

    // TODO: 2023/02/20 메소드명 변경
    private void validateResultSize(List<String> results, int userCount) {
        if (results.size() != userCount) {
            throw new IllegalArgumentException(
                String.format(INVALID_RESULT_SIZE.getMessage(),
                    userCount));
        }
    }
}
