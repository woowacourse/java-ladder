package domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Bridge {
    EXIST(true, "-----"),
    NON_EXIST(false, "     ");

    private final boolean isExist;
    private final String format;

    Bridge(boolean isExist, String format) {
        this.isExist = isExist;
        this.format = format;
    }

    private static final Map<Boolean, Bridge> bridges =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Bridge::isExist, Function.identity())));

    public static Bridge from(boolean isExist) {
        return bridges.get(isExist);
    }

    public boolean isExist() {
        return isExist;
    }

    public String getFormat() {
        return format;
    }
}
