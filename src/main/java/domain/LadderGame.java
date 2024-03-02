package domain;

import domain.ladder.Ladder;
import domain.player.Name;
import domain.player.Names;
import domain.result.Prizes;
import java.util.List;

public class LadderGame {
    private final Names names;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGame(Names names, Prizes prizes, Ladder ladder) {
        validate(names, prizes, ladder);
        this.names = names;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    private void validate(Names names, Prizes prizes, Ladder ladder) {
        if (names == null || prizes == null || ladder == null) {
            throw new IllegalArgumentException("null 객체를 사용해 LadderGame을 생성할 수 없습니다.");
        }
        if (names.size() != prizes.size()) {
            throw new IllegalArgumentException("이름과 결과의 개수는 같아야 합니다.\n"
                    + "이름의 개수 : " + names.size() + ", 결과의 개수 : " + prizes.size());
        }
        if (names.size() != ladder.getLegSize()) {
            throw new IllegalArgumentException("이름의 개수와 사다리의 다리 개수는 같아야 합니다.\n"
                    + "이름의 개수 : " + names.size() + ", 다리 개수 : " + ladder.getLegSize());
        }
    }

    public List<MatchingResult> findAllResult() {
        return names.getNames().stream()
                .map(this::findEachPrize)
                .toList();
    }

    public MatchingResult findEachPrize(Name name) {
        int nameIndex = names.getIndexOf(name);
        int prizeIndex = ladder.getMatchedIndex(nameIndex);
        return new MatchingResult(name, prizes.get(prizeIndex));
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Prizes getResult() {
        return prizes;
    }
}
