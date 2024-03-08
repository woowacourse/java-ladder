package domain;

import domain.name.Name;
import domain.name.Names;
import domain.prize.Prize;
import domain.prize.Prizes;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGameResult {

    private final Names names;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGameResult(Names names, Prizes prizes, Ladder ladder) {
        this.names = names;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public Prize getOneResult(Name name) {
        int nameIndex = names.getNames().indexOf(name);
        return prizes.getBy(ladder.findPrizeIndex(nameIndex));
    }

    public Map<Name, Prize> getAllResult() {
        Map<Name, Prize> allResults = new LinkedHashMap<>();
        Map<Integer, Integer> indexConnections = ladder.matchLadderPoints();
        for (int i = 0; i < names.size(); i++) {

            allResults.put(names.getByIndex(i),
                    prizes.findByIndex(indexConnections.get(i)));
        }
        return Collections.unmodifiableMap(allResults);
    }
}
