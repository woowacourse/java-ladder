package laddergame.domain.gameelements;

public class Element {
    private static final String ELEMENT_NAME_RULE = "[a-zA-Z0-9]{1,5}";
    private final String elementName;

    public Element(String playerName) {
        validateNameRule(playerName);
        this.elementName = playerName;
    }

    protected void validateNameRule(String name) {
        if (name == null || !name.matches(ELEMENT_NAME_RULE)) {
            throw new IllegalArgumentException("게임 요소의 이름은 5자 이내의 영숫자로 구성되어야 합니다.");
        }
    }

    public String getElement() {
        return elementName;
    }
}
