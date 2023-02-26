package ladder.domain;

public class Prize {
    private static final String NAME_BLANK_ERROR_MESSAGE = "상품명은 공백으로만 이루어질 수 없습니다.";
    private final String name;

    public Prize(String name) {
        validateOnlyBlank(name);
        this.name = name;
    }

    private void validateOnlyBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
