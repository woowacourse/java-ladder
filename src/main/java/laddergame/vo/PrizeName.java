package laddergame.vo;

public class PrizeName {
    private static final String RESTRICTED = " ";
    private final String name;

    public PrizeName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNameLength(name);
        validateHasNoRestricted(name);
    }

    private void validateNameLength(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("상품 이름 길이는 1이상이어야합니다.");
        }
    }

    private void validateHasNoRestricted(String name) {
        if (name.contains(RESTRICTED)) {
            throw new IllegalArgumentException("상품 이름에는 공백이 포함될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
