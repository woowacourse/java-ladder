package ladderGame.domain;

import ladderGame.util.StringUtil;

import java.util.List;

public class Result {
    private List<String> results;

    public Result(String results) {
        this.results = StringUtil.splitComma(results);
    }

    public List<String> getResults() {
        return results;
    }
}
