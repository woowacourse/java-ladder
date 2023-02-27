package ladder.domain;

import ladder.util.BooleanGenerator;

import java.util.*;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int countOfParticipants, Height height, BooleanGenerator generator) {
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(new Line(countOfParticipants, generator));
        }
    }

    public Result perform(Names names, Bets bets) {
        List<Bet> performedBets = new ArrayList<>(bets.getBets());

        for (int i = ladder.size() - 1; i >= 0; i--) {
            performByLine(ladder.get(i), performedBets);
        }

        return makeResult(names, performedBets);
    }

    private void performByLine(Line line, List<Bet> bets) {
        for (int i = 0; i < line.size(); i++) {
            swapBetIfExistLine(bets, i, line.existLineAtCell(i));
        }
    }

    private void swapBetIfExistLine(List<Bet> bets, int index, boolean exist) {
        if (!exist) {
            return;
        }

        Collections.swap(bets, index, index + 1);
    }

    private Result makeResult(Names names, List<Bet> performedBets) {
        Map<Name, Bet> result = new LinkedHashMap<>();

        for (int i = 0; i < names.size(); i++) {
            result.put(names.getNames().get(i), performedBets.get(i));
        }

        return new Result(result);
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
