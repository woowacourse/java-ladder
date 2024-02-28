package view.dto;

import domain.Line;
import domain.Player;
import domain.Players;
import domain.Results;

import java.util.List;

public class LadderResultDto {

    private final List<Player> players;
    private final List<Line> lines;
    private final Results results;

    private LadderResultDto(List<Player> players, List<Line> lines, Results results) {
        this.players = players;
        this.lines = lines;
        this.results = results;
    }

    public static LadderResultDto of(Players players, List<Line> lines, Results results) {
        return new LadderResultDto(players.getPlayers(), lines, results);
    }


    public List<Player> getPlayers() {
        return players;
    }

    public List<Line> getLines() {
        return lines;
    }

    public Results getResults() {
        return results;
    }
}
