package domain;

import java.util.Collections;
import java.util.List;

public record LadderRowPattern(List<Boolean> rowPattern) {

    @Override
    public List<Boolean> rowPattern() {
        return Collections.unmodifiableList(rowPattern);
    }
}
