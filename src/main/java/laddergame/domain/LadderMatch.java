package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderMatch {
    private static final String MATCH_RESULTS_COMMAND = "all";
    private static final String LADDER_NULL_EXCEPTION = "Ladder는 null이 될 수 없습니다.";
    private static final String PARTICIPANTS_NULL_EXCEPTION = "Participants는 null이 될 수 없습니다.";
    private static final String RESULTS_NULL_EXCEPTION = "Results는 null이 될 수 없습니다.";

    private final Ladder ladder;
    private final Participants participants;
    private final Results results;

    public LadderMatch(final Ladder ladder, final Participants participants, final Results results) {
        this.ladder = getLadder(ladder);
        this.participants = getParticipants(participants);
        this.results = getResults(results);
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
        final Result findResult = results.findResultByPosition(findDestination);
        final Name findName = participants.findNameByPosition(findParticipantPosition);

        return Map.of(findName, findResult);
    }

    private List<Result> findMatchResults(final int matchSize) {
        return IntStream.range(0, matchSize)
                .mapToObj(Position::new)
                .map(ladder::findLastDestination)
                .map(results::findResultByPosition)
                .collect(Collectors.toUnmodifiableList());
    }

    private Results getResults(final Results results) {
        return Optional.ofNullable(results)
                .orElseThrow(() -> new IllegalArgumentException(RESULTS_NULL_EXCEPTION));
    }

    private Participants getParticipants(final Participants participants) {
        return Optional.ofNullable(participants)
                .orElseThrow(() -> new IllegalArgumentException(PARTICIPANTS_NULL_EXCEPTION));
    }

    private Ladder getLadder(final Ladder ladder) {
        return Optional.ofNullable(ladder)
                .orElseThrow(() -> new IllegalArgumentException(LADDER_NULL_EXCEPTION));
    }
}
