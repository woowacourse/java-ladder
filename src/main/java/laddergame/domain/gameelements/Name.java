package laddergame.domain.gameelements;

import java.util.Objects;

public class Name {
    // TODO  text 상수로 추출해보기
    private static final String ELEMENT_NAME_RULE = "[ㄱ-ㅎ가-힣a-zA-Z0-9]{1,5}";
    private static final String RESERVED_NAME = "all";

    private final String name;

    public Name(String name) {
        validateNameRule(name);
        this.name = name;
    }

    public static Name reservedName() {
        return new Name(RESERVED_NAME);
    }

    private void validateNameRule(String name) {
        if (name == null || !name.matches(ELEMENT_NAME_RULE)) {
            throw new IllegalArgumentException("게임 요소의 이름은 5자 이내의 영숫자로 구성되어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Name otherName) {
            return name.equals(otherName.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
