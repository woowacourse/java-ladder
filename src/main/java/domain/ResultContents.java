package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultContents {

    private final List<ResultContent> resultContents;

    public ResultContents(List<ResultContent> resultContents) {
        this.resultContents = resultContents;
    }

    public static ResultContents from(List<String> resultContentsValue) {
        return new ResultContents(resultContentsValue.stream()
                .map(ResultContent::new)
                .collect(Collectors.toList()));
    }

    public List<ResultContent> getResultContents() {
        return Collections.unmodifiableList(this.resultContents);
    }

}
