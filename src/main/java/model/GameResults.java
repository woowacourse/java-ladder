package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResults {

    private final List<GameResult> gameResults;

    private GameResults(List<GameResult> gameResults) {
        this.gameResults = new ArrayList<>(gameResults);
    }

    public static GameResults of(Names names, Ladder ladder, LadderResults ladderResults) {
        List<GameResult> gameResults = IntStream.range(0, names.getTotalParticipantSize())
                .map(participantPosition -> playLadderGame(participantPosition, ladder))
                .mapToObj(index -> mapToGameResult(names, ladderResults, index))
                .collect(Collectors.toUnmodifiableList());

        return new GameResults(gameResults);
    }

    private static int playLadderGame(int position, Ladder ladder) {
        Queue<Line> lines = new LinkedList<>(ladder.getLines());

        while (!lines.isEmpty()) {
            Line positionLine = lines.poll();
            Direction direction = positionLine.findDirection(position);
            position = direction.move(position);
        }
        return position;
    }

    private static GameResult mapToGameResult(Names names, LadderResults ladderResults, int index) {
        String participantName = names.findNameByIndex(index);
        String participantResult = ladderResults.findResultByIndex(index);

        return new GameResult(participantName, participantResult);
    }

    public GameResult findGameResultByName(String name) {
        return gameResults.stream()
                .filter(gameResult -> gameResult.matchesByName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자 이름입니다."));
    }

    public List<GameResult> getGameResults() {
        return List.copyOf(gameResults);
    }
}
