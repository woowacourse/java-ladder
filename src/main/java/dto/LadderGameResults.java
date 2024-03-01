package dto;

import java.util.HashSet;
import java.util.List;

public record LadderGameResults(List<LadderGameResult> ladderGameResults) {

    public static LadderGameResults of(LadderGameResult... ladderGameResults) {
        return new LadderGameResults(List.of(ladderGameResults));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LadderGameResults that = (LadderGameResults) o;
        boolean thatContainsThis = new HashSet<>(that.ladderGameResults).containsAll(ladderGameResults);
        boolean thisContainsThat = new HashSet<>(ladderGameResults).containsAll(that.ladderGameResults);
        return thatContainsThis && thisContainsThat;
    }

}
