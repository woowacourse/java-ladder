package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class GameResults {

    private final List<GameResult> gameResults;

    private GameResults(List<GameResult> gameResults) {
        this.gameResults = new ArrayList<>(gameResults);
    }

    public static GameResults of(Names names, Ladder ladder, LadderResults ladderResults) {
        List<GameResult> gameResults = new ArrayList<>();

        for (int position = 0; position < names.getTotalParticipantSize(); position++) {
            String name = names.findNameByIndex(position);
            int ladderResultPosition = playLadderGame(position, ladder);
            String participantLadderResult = ladderResults.findResultByIndex(ladderResultPosition);

            gameResults.add(new GameResult(name, participantLadderResult));
        }
        return new GameResults(gameResults);
    }

    private static int playLadderGame(int position, Ladder ladder) {
        Queue<Line> lines = ladder.mapToLines();

        while (!lines.isEmpty()) {
            Line positionLine = lines.poll();
            Direction direction = positionLine.findDirection(position);
            position = direction.move(position);
        }
        return position;
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
