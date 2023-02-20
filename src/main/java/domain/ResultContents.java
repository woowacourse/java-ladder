package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ResultContents {

    private final List<ResultContent> resultContents;

    public ResultContents(List<ResultContent> resultContents) {
        this.resultContents = resultContents;
    }

    public static ResultContents of(String inputValue, String delimiter) {
        return new ResultContents(Arrays.stream(inputValue.split(delimiter, -1))
                .map(String::trim)
                .map(ResultContent::new)
                .collect(Collectors.toList()));
    }

    public List<ResultContent> getResultContents() {
        return Collections.unmodifiableList(this.resultContents);
    }

}
