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
import laddergame.exception.LadderGameException;

public class LadderGame {

    private final LadderGenerator ladderGenerator;
    private final Map<Name, Result> matchRepository = new LinkedHashMap<>();

    public LadderGame(final LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public LadderResult createLadder(final Names names, final Results results, final LadderHeight ladderHeight) {
        validateSize(names, results);
        final LineSize lineSize = new LineSize(names);
        final Ladder ladder = ladderGenerator.generate(lineSize, ladderHeight);

        saveMatchingResult(names, results, ladder);

        return LadderResult.of(names, ladder, results);
    }

    private void validateSize(final Names names, final Results results) {
        if (names.size() != results.size()) {
            throw new LadderGameException("[ERROR] 참가자와 결과 수가 같아야합니다.");
        }
    }

    private void saveMatchingResult(final Names names, final Results results, final Ladder ladder) {
        final int size = names.size();

        for (int i = 0; i < size; i++) {
            final Position namePosition = new Position(i);
            final Position resultPosition = ladder.goDown(namePosition);

            final Result result = results.get(resultPosition);
            final Name name = names.get(namePosition);
            matchRepository.put(name, result);
        }
    }

    public Result findResultByName(final Name name) {
        if (matchRepository.containsKey(name)) {
            return matchRepository.get(name);
        }

        throw new IllegalArgumentException("[ERROR] 존재하지 않는 이름입니다.");
    }

    public List<MatchingResult> findResultAll() {
        return matchRepository.entrySet().stream()
                .map(MatchingResult::from)
                .toList();
    }
}
