package model.domain;

import model.vo.Result;

import java.util.List;
import java.util.stream.IntStream;

public class LadderGame {
    private Players players;
    private Ladder ladder;
    private List<Result> results;

    public LadderGame(Players players, Ladder ladder, List<Result> results) {
        this.players = players;
        this.ladder = ladder;
        this.results = results;
    }

    public Players getPlayersAfterPlay() {
        play();
        return players;
    }

    private void play() {
        IntStream.range(0, ladder.getHeight())
                .forEach(index -> playOneLine(players, ladder.getLine(index)));
        players.saveAllResults(results);
    }

    private void playOneLine(Players players, Line line) {
        players.moveAllPlayersByLinePoints(line.getPoints());
    }
}
