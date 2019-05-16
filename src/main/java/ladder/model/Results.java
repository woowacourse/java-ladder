package ladder.model;

import ladder.model.frame.Input;

public class Results extends Input<ResultName> {
    private static final String PLAYERS_RESULTS_NUMBER_ERROR = "플레이어수와 결과수가 다릅니다.";

    public Results(String input, int playerNumbers) {
        super(input);
        addNames(input);
        checkValidNumbers(playerNumbers);
    }

    @Override
    protected void addNames(String input) {
        for(String name : input.split(DELIMITER)){
            names.add(new ResultName(name));
        }
    }

    private void checkValidNumbers(int playerNumbers) {
        if (names.size() != playerNumbers) {
            throw new IllegalArgumentException(PLAYERS_RESULTS_NUMBER_ERROR);
        }
    }

    public ResultName getResultNameByIndex(int index) {
        return this.names.get(index);
    }


}
