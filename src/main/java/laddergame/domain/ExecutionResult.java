package laddergame.domain;

import java.util.List;

public class ExecutionResult {
    private final List<String> elements;

    public ExecutionResult(List<String> elements, int elementsCount) {
        validate(elements, elementsCount);
        this.elements = elements;
    }

    public void validate(List<String> elements, int elementsCount) {
        checkExecutionResultCount(elements, elementsCount);
    }

    public void checkExecutionResultCount(List<String> elements, int elementsCount) {
        if (elements.size() != elementsCount) {
            throw new IllegalArgumentException();
        }
    }
}
