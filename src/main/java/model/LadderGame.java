package model;

import dto.GameResult;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final Names names;
    private final LadderResults gameResults;

    public LadderGame(Names names, LadderResults gameResults) {
        this.names = names;
        this.gameResults = gameResults;
    }

    public static LadderGame of(Names names, Ladder ladder, LadderResults ladderResults) {
        List<Integer> gameResult = IntStream.range(0, names.getTotalParticipantSize())
                .map(participantPosition -> playLadderGame(participantPosition, ladder))
                .boxed()
                .collect(Collectors.toList());
        LadderResults gameResults = ladderResults.calculateGameResult(gameResult);

        return new LadderGame(names, gameResults);
    }

    private static int playLadderGame(int position, Ladder ladder) {
        Queue<Line> queue = new LinkedList<>(ladder.getLines());

        while (!queue.isEmpty()) {
            Line positionLine = queue.poll();
            Direction direction = positionLine.findDirection(position);
            position = direction.move(position);
        }
        return position;
    }

    public String findGameResultByName(String name) {
        int indexOfName = names.findIndexByName(name);

        return gameResults.findResultByIndex(indexOfName);
    }

    public List<GameResult> findGameResultAll() {
        return IntStream.range(0, names.getTotalParticipantSize())
                .mapToObj(index -> new GameResult(names.findNameByIndex(index),
                        gameResults.findResultByIndex(index)))
                .collect(Collectors.toUnmodifiableList());
    }
}
