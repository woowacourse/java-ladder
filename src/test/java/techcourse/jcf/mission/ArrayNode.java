package techcourse.jcf.mission;

import java.util.Objects;

public class ArrayNode {
    private final String value;

    public ArrayNode(String value) {
        this.value = value;
    }

    public boolean isValueMatch(String value) {
        return Objects.equals(this.value, value);
    }

    public String getValue() {
        return value;
    }
}
