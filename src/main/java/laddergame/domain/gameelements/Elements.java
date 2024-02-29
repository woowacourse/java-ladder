package laddergame.domain.gameelements;

import java.util.Collections;
import java.util.List;
// TODO Players, Prizes 분리하기
public class Elements {

    private static final int MIN_ELEMENT_NUMBERS = 1;
    private static final int MAX_ELEMENT_NUMBERS = 100;

    private final List<Name> names;

    public Elements(List<String> elements) {
        validateElementNumber(elements);
        this.names = elements.stream()
                .map(Name::new)
                .toList();
    }

    private void validateElementNumber(List<String> elements) {
        if (elements.size() < MIN_ELEMENT_NUMBERS || elements.size() > MAX_ELEMENT_NUMBERS) {
            throw new IllegalArgumentException("게임 요소의 수는 1이상 100이하만 가능합니다.");
        }
    }
    //TODO Stream.java의 toList() 살펴보기
    public List<Name> getElements() {
        return Collections.unmodifiableList(names);
    }
}
