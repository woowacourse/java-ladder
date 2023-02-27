package ladder.domain;

import ladder.error.ErrorMessage;

import java.util.*;

public class Result {
    private final Map<Name, Bet> result = new LinkedHashMap<>();

    public Result(Names names, Bets bets) {
        validate(names, bets);

        for (int i = 0; i < names.size(); i++) {
            result.put(names.getNames().get(i), bets.getBets().get(i));
        }
    }

    private void validate(Names names, Bets bets) {
        if (names.size() != bets.size())
            throw new IllegalArgumentException(ErrorMessage.DIFFERENT_PARTICIPANTS_AND_BETS_COUNT.getMessage());
    }

    public void perform(Ladder ladder) {
        List<Name> names = List.copyOf(result.keySet());
        List<Bet> bets = new ArrayList<>(result.values());

        for (int i = ladder.getLadder().size() - 1; i >= 0; i--) {
            Line line = ladder.getLadder().get(i);
            performByLine(line, bets);
        }

        update(names, bets);
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

    private void update(List<Name> names, List<Bet> bets) {
        for (int i = 0; i < names.size(); i++) {
            result.put(names.get(i), bets.get(i));
        }
    }

    public Bet getBetByName(Name name) {
        Bet bet = result.get(name);

        if (bet == null) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_NOT_EXIST.getMessage());
        }

        return bet;
    }

    public int size() {
        return result.size();
    }

    public Map<Name, Bet> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
