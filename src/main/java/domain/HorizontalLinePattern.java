package domain;

import java.util.Collections;
import java.util.List;

public record HorizontalLinePattern(List<Boolean> rowPattern) {

    public List<Boolean> rowPattern() {
        return Collections.unmodifiableList(rowPattern);
    }
}
