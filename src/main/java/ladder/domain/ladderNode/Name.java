package ladder.domain.ladderNode;

import java.util.Objects;

public class Name {
    private static final int MAX_SIZE = 5;
    private final String name;

    public Name(String name) {
        validateEmptyName(name);
        validateOutOfNameLength(name);
        this.name = name;
    }

    private void validateEmptyName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름과 실행결과는 빈 문자일 수 없습니다.");
        }
    }

    private void validateOutOfNameLength(String name) {
        if (name.length() > MAX_SIZE) {
            throw new IllegalArgumentException("이름과 실행결과는 최대 5글자이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
