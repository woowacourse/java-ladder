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
    private final LadderIndexConnection ladderIndexConnection;

    public LadderGameResult(Names names, Prizes prizes, LadderIndexConnection ladderIndexConnection) {
        this.names = names;
        this.prizes = prizes;
        this.ladderIndexConnection = ladderIndexConnection;
    }

    public Prize getOneResult(Name name) {
        int nameIndex = names.getNames().indexOf(name);
        return prizes.getOnePrizeByIndex(ladderIndexConnection.getPrizeIndex(nameIndex));
    }

    public Map<Name, Prize> getAllResult() {
        Map<Name, Prize> allResults = new LinkedHashMap<>();
        for (int i = 0; i < names.getNameCount(); i++) {
            allResults.put(names.getByIndex(i),
                    prizes.getPrizes().get(ladderIndexConnection.getResult().get(i)));
        }
        return Collections.unmodifiableMap(allResults);
    }
}
