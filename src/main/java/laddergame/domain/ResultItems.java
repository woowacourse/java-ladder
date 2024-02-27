package laddergame.domain;

import java.util.List;

public class ResultItems {
    private final List<String> elements;

    public ResultItems(List<String> elements, int elementsCount) {
        validate(elements, elementsCount);
        this.elements = elements;
    }

    public void validate(List<String> elements, int elementsCount) {
        checkResultItemCount(elements, elementsCount);
    }

    public void checkResultItemCount(List<String> elements, int elementsCount) {
        if (elements.size() != elementsCount) {
            throw new IllegalArgumentException();
        }
    }

    public String findByIndex(int index) {
        return elements.get(index);
    }
}
