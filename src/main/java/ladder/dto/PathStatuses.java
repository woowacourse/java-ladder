package ladder.dto;

import ladder.constant.PathStatus;
import ladder.domain.Paths;

import java.util.List;

public record PathStatuses(List<PathStatus> pathStatuses) {

    public static PathStatuses of(Paths paths) {
        return new PathStatuses(paths.getPathStatuses());
    }
}
