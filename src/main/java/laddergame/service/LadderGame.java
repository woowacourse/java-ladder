package laddergame.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGenerator;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.ladder.LineSize;
import laddergame.domain.ladder.Position;
import laddergame.domain.name.Name;
import laddergame.domain.name.Names;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;
import laddergame.dto.LadderResult;
import laddergame.dto.MatchingResult;

public class LadderGame {

    private final LadderGenerator ladderGenerator;
    private final Map<Name, Result> matchRepository = new LinkedHashMap<>();

    public LadderGame(final LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public LadderResult createLadder(final Names names, final Results results, final LadderHeight ladderHeight) {
        final LineSize lineSize = new LineSize(names);
        final Ladder ladder = ladderGenerator.generate(lineSize, ladderHeight);

        saveMatchingResult(names.getNames(), results.getResults(), ladder);

        return LadderResult.of(names, ladder, results);
    }

    private void saveMatchingResult(final List<Name> names, final List<Result> results, final Ladder ladder) {
        final int size = names.size();

        for (int i = 0; i < size; i++) {
            final Position namePosition = new Position(i);
            final Position resultPosition = ladder.goDown(namePosition);

            final Result result = results.get(resultPosition.getPosition());
            final Name name = names.get(namePosition.getPosition());
            matchRepository.put(name, result);
        }
    }

    public Result findResultByName(final Name name) {
        return matchRepository.get(name);
    }

    public List<MatchingResult> findAll() {
        return matchRepository.entrySet().stream()
                .map(MatchingResult::from)
                .toList();
    }
}
