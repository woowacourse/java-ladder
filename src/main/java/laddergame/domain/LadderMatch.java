package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static laddergame.utils.OptionalUtils.getValueAfterNullCheck;

public class LadderMatch {
    private static final String MATCH_RESULTS_COMMAND = "all";

    private final Ladder ladder;
    private final Participants participants;
    private final GameResults gameResults;

    public LadderMatch(final Ladder ladder, final Participants participants, final GameResults gameResults) {
        this.ladder = getValueAfterNullCheck(ladder);
        this.participants = getValueAfterNullCheck(participants);
        this.gameResults = getValueAfterNullCheck(gameResults);
    }

    public Map<Name, Result> getLadderMatchResults(final String command) {
        if (command.equals(MATCH_RESULTS_COMMAND)) {
            return getAllMatchedResults();
        }
        return getOneMatchedResult(command);
    }

    private Map<Name, Result> getAllMatchedResults() {
        final int matchSize = participants.getSize();
        final Map<Name, Result> matchResults = new LinkedHashMap<>();
        final List<Result> findResults = findMatchResults(matchSize);
        for (int index = 0; index < matchSize; index++) {
            final Position position = new Position(index);
            matchResults.put(participants.findNameByPosition(position), findResults.get(index));
        }

        return matchResults;
    }

    private Map<Name, Result> getOneMatchedResult(final String name) {
        final Position findParticipantPosition = participants.findPositionByName(name);
        final Position findDestination = ladder.findLastDestination(findParticipantPosition);
        final Result findResult = gameResults.findResultByPosition(findDestination);
        final Name findName = participants.findNameByPosition(findParticipantPosition);

        return Map.of(findName, findResult);
    }

    private List<Result> findMatchResults(final int matchSize) {
        return IntStream.range(0, matchSize)
                .mapToObj(Position::new)
                .map(ladder::findLastDestination)
                .map(gameResults::findResultByPosition)
                .collect(Collectors.toUnmodifiableList());
    }
}
