package ladder.model.objectname;

import ladder.constant.MessageConstant;

import java.util.Objects;

public class LadderObjectName {
    private final String name;

    public LadderObjectName(String name) {
        this.name = getAccuracyOf(name);
    }

    private static String getAccuracyOf(String name) {
        if (name == null) {
            throw new IllegalArgumentException(MessageConstant.ERROR_NULL);
        }
        name = name.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EMPTY_VALUE);
        }
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LadderObjectName that = (LadderObjectName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
