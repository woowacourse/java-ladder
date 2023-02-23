package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static laddergame.utils.OptionalUtils.getValueAfterNullCheck;

public class LadderMatch {
    private final Ladder ladder;
    private final Participants participants;
    private final GameResults gameResults;

    public LadderMatch(final Ladder ladder, final Participants participants, final GameResults gameResults) {
        this.ladder = getValueAfterNullCheck(ladder);
        this.participants = getValueAfterNullCheck(participants);
        this.gameResults = getValueAfterNullCheck(gameResults);
    }

    public LadderMatchResults getAllMatchedResults() {
        final List<String> findResults = findMatchResultValues();
        final Names names = participants.getNames();
        final GameResults matchedGameResult = new GameResults(findResults, names);

        return new LadderMatchResults(names, matchedGameResult);
    }

    public LadderMatchResults getOneMatchedResult(final String name) {
        final Position findParticipantPosition = participants.findPositionByName(name);
        final Position findDestination = ladder.findLastDestination(findParticipantPosition);
        final Result findResult = gameResults.findResultByPosition(findDestination);
        final Name findName = participants.findNameByPosition(findParticipantPosition);

        return new LadderMatchResults(findName, findResult);
    }

    private List<String> findMatchResultValues() {
        final int matchSize = participants.getSize();
        return IntStream.range(0, matchSize)
                .mapToObj(Position::new)
                .map(ladder::findLastDestination)
                .map(gameResults::findResultByPosition)
                .map(Result::getValue)
                .collect(Collectors.toUnmodifiableList());
    }
}
