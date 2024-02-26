package laddergame.domain.gameelements;

import java.util.Collections;
import java.util.List;

public class Elements {

    private static final int MIN_ELEMENT_NUMBERS = 1;
    private static final int MAX_ELEMENT_NUMBERS = 100;

    private final List<Element> elements;

    public Elements(List<String> elements) {
        validateElementNumber(elements);
        this.elements = elements.stream()
                .map(Element::new)
                .toList();
    }

    private void validateElementNumber(List<String> elements) {
        if (elements.size() < MIN_ELEMENT_NUMBERS || elements.size() > MAX_ELEMENT_NUMBERS) {
            throw new IllegalArgumentException("게임 요소의 수는 1이상 100이하만 가능합니다.");
        }
    }

    public List<Element> getElements() {
        return Collections.unmodifiableList(elements);
    }
}
