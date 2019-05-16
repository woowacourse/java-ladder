package ladder.domain;

public class Results extends NameContainer {
    private static final String PLAYERS_RESULTS_NUMBER_ERROR = "플레이어수와 결과수가 다릅니다.";

    public Results(String input, int playerNumbers) {
        super(input);
        checkValidNumbers(playerNumbers);
    }

    private void checkValidNumbers(int playerNumbers) {
        if (names.size() != playerNumbers) {
            throw new IllegalArgumentException(PLAYERS_RESULTS_NUMBER_ERROR);
        }
    }

    public Name get(int index) {
        return names.get(index);
    }

    @Override
    public void add(String name) {
        names.add(new Name(name));
    }
}
