package domain;

import java.util.List;

public class ResultContents {

    private final List<ResultContent> resultContents;

    public ResultContents(List<ResultContent> resultContents) {
        this.resultContents = resultContents;
    }

    public List<ResultContent> getResultContents() {
        return resultContents;
    }
}
