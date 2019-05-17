package ladder.domain;

import java.util.Objects;

public class ResultItem {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MINIMUM_NANE_LENGTH = 1;

    private final String itemName;

    public ResultItem(String itemName) {
        nullCheck(itemName);
        this.itemName = getTrimed(itemName);
    }

    private void nullCheck(String name) {
        if (name == null) {
            throw new IllegalArgumentException("당첨 항목은 null이 입력될 수 없습니다.");
        }
    }

    private String getTrimed(String name) {
        name = name.trim();
        vaildateNameLength(name);
        return name;
    }

    private void vaildateNameLength(String name) {
        if ((name.length() > MAXIMUM_NAME_LENGTH) || (name.length() < MINIMUM_NANE_LENGTH)) {
            throw new IllegalArgumentException("당첨 항목의 길이는 5자 이하여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultItem that = (ResultItem) o;
        return Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }
}
