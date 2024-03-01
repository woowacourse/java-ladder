package dto;

import domain.ladder.PathStatus;
import domain.ladder.Paths;

import java.util.List;

public record PathStatusesDto(List<PathStatus> pathStatuses) {

    public static PathStatusesDto of(Paths paths) {
        return new PathStatusesDto(paths.getPathStatuses());
    }
}
