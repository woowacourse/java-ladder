package domain;

import java.util.Collections;
import java.util.List;

public record HorizontalLineStatus(List<Boolean> placedStatuses) {

    public List<Boolean> placedStatuses() {
        return Collections.unmodifiableList(placedStatuses);
    }
}
