package controller.dto;

import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.ladder.Point;
import domain.players.Players;
import domain.prize.Prizes;

import java.util.List;
import java.util.stream.Collectors;

public class LadderResponse {

    private final List<List<Boolean>> ladder;
    private final List<String> players;
    private final List<String> prizes;

    public LadderResponse(List<List<Boolean>> ladder, List<String> players, List<String> prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public static LadderResponse of(final Ladder ladder, final Players players, final Prizes prizes) {
        List<List<Boolean>> ladderResponse = ladder.getLines().stream()
                .map(Line::getPoints)
                .map(LadderResponse::convertPointsToValues)
                .collect(Collectors.toUnmodifiableList());
        List<String> playerNames = players.getPlayerNames();
        List<String> prizeValues = prizes.getPrizeValues();
        return new LadderResponse(ladderResponse, playerNames, prizeValues);
    }

    private static List<Boolean> convertPointsToValues(List<Point> points) {
        return points.stream()
                .map(Point::isExist)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<List<Boolean>> getLadder() {
        return ladder;
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<String> getPrizes() {
        return prizes;
    }
    
}
