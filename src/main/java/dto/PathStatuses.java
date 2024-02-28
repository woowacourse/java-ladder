package dto;

import constant.PathStatus;
import domain.ladder.Paths;

import java.util.List;

public record PathStatuses(List<PathStatus> pathStatuses) {

    public static PathStatuses of(Paths paths) {
        return new PathStatuses(paths.getPathStatuses());
    }
}
