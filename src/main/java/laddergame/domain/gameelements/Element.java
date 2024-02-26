package laddergame.domain.gameelements;

public class Element {
    private static final String ELEMENT_NAME_RULE = "[ㄱ-ㅎ가-힣a-zA-Z0-9]{1,5}";
    private final String element;

    public Element(String element) {
        validateNameRule(element);
        this.element = element;
    }

    private void validateNameRule(String name) {
        if (name == null || !name.matches(ELEMENT_NAME_RULE)) {
            throw new IllegalArgumentException("게임 요소의 이름은 5자 이내의 영숫자로 구성되어야 합니다.");
        }
    }

    public String getElement() {
        return element;
    }

}
