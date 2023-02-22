package model;

import dto.GameResult;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private final Names names;
    private final LadderResults ladderResults;
    private final List<Integer> gameResult;

    public LadderGame(Names names, LadderResults ladderResults, List<Integer> gameResult) {
        this.names = names;
        this.ladderResults = ladderResults;
        this.gameResult = gameResult;
    }

    public static LadderGame of(Names names, Ladder ladder, LadderResults ladderResults) {
        List<Integer> gameResult = IntStream.range(0, names.getTotalParticipantSize())
                .map(participantPosition -> playLadderGame(participantPosition, ladder))
                .boxed()
                .collect(Collectors.toList());

        return new LadderGame(names, ladderResults, gameResult);
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
        int resultIndex = gameResult.get(indexOfName);

        return ladderResults.findResultByIndex(resultIndex);
    }

    public List<GameResult> findGameResultAll() {
        return IntStream.range(0, gameResult.size())
                .mapToObj(index -> new GameResult(names.findNameByIndex(index),
                        ladderResults.findResultByIndex(gameResult.get(index))))
                .collect(Collectors.toUnmodifiableList());
    }
}
