package domain.ladder;

import domain.player.Name;
import domain.player.Players;
import domain.result.Result;
import domain.result.Results;
import dto.RowPatternDto;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.stream.IntStream;

public class Ladder {

    private final Players players;
    private final Results results;
    private final List<LadderRow> rows = new ArrayList<>();
    private final LadderIndexConverter ladderIndexConverter;

    public Ladder(Players players, Results results, LadderHeight height) {
        validateHasSameSize(players, results);
        this.players = players;
        this.results = results;

        createLadder(height);
        ladderIndexConverter = new LadderIndexConverter(players.size());
    }

    public void drawLines(BooleanSupplier patternCreationStrategy) {
        rows.forEach(row -> {
            row.createPattern(patternCreationStrategy);
            ladderIndexConverter.swapByRowPattern(row.getRowPattern());
        });
    }

    public Result getResultByName(String name) {
        int index = players.getIndexByName(name);
        int resultIndex = ladderIndexConverter.getMappedIndexByPlayerIndex(index);
        return results.get(resultIndex);
    }

    public Map<Name, Result> getAllPlayerResults() {
        List<Result> mappedResults = players.getRawNames()
                .stream()
                .map(this::getResultByName)
                .toList();

        Map<Name, Result> playerResults = new LinkedHashMap<>();
        IntStream.range(0, players.size())
                .forEach(index -> playerResults.put(players.get(index), mappedResults.get(index)));

        return playerResults;
    }

    public List<RowPatternDto> getLadderPatterns() {
        return rows.stream()
                .map(LadderRow::getRowPattern)
                .toList();
    }

    private void createLadder(LadderHeight height) {
        int createdRowCount = 0;
        while (!height.isSameHeightAs(createdRowCount)) {
            LadderRow line = new LadderRow(players.size());
            rows.add(line);
            createdRowCount++;
        }
    }

    private void validateHasSameSize(Players players, Results results) {
        if (players.size() != results.size()) {
            throw new IllegalArgumentException("사람의 수와 결과의 개수가 일치하지 않습니다.");
        }
    }
}
