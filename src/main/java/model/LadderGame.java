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

    private LadderGame(Names names, LadderResults gameResults) {
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
        Queue<Line> lines = new LinkedList<>(ladder.getLines());

        while (!lines.isEmpty()) {
            Line positionLine = lines.poll();
            Direction direction = positionLine.findDirection(position);
            position = direction.move(position);
        }
        return position;
    }

    public List<GameResult> findGameResult(String name) {
        if (LadderGameCommand.ALL_RESULT_PRINT_AND_EXIT_COMMAND.isPlayable(name)) {
            return findGameResultByName(name);
        }
        return findGameResultAll();
    }

    private List<GameResult> findGameResultByName(String name) {
        int index = names.findIndexByName(name);
        String participantName = names.findNameByIndex(index);
        String gameResult = gameResults.findResultByIndex(index);
        GameResult participantGameResult = new GameResult(participantName, gameResult);

        return List.of(participantGameResult);
    }

    private List<GameResult> findGameResultAll() {
        return IntStream.range(0, names.getTotalParticipantSize())
                .mapToObj(index -> new GameResult(names.findNameByIndex(index),
                        gameResults.findResultByIndex(index)))
                .collect(Collectors.toUnmodifiableList());
    }
}
