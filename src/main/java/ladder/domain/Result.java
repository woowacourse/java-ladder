package ladder.domain;

import ladder.util.StringUtil;

import java.util.List;

public class Result {
    private List<String> results;

    public Result(String results, int size) {
        this.results = StringUtil.splitComma(results);
        checkResultSize(size);
    }

    private void checkResultSize(int size) {
        if (size != results.size()) {
            throw new IllegalArgumentException("결과 수가 참여자 수와 동일하지 않습니다.");
        }
    }

    public List<String> getResults() {
        return results;
    }
}
