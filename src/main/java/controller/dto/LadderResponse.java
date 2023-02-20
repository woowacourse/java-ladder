package controller.dto;

import domain.Ladder;
import domain.Line;
import domain.Point;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResponse {

    private final List<List<Boolean>> ladder;

    private LadderResponse(List<List<Boolean>> ladder) {
        this.ladder = ladder;
    }

    public static LadderResponse from(final Ladder ladder) {
        List<List<Boolean>> ladderResponse = ladder.getLines().stream()
                .map(Line::getPoints)
                .map(LadderResponse::convertPointsToValues)
                .collect(Collectors.toUnmodifiableList());
        return new LadderResponse(ladderResponse);
    }

    private static List<Boolean> convertPointsToValues(List<Point> points) {
        return points.stream()
                .map(Point::isExist)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<List<Boolean>> getLadder() {
        return ladder;
    }

}
