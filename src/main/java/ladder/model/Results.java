package ladder.model;

import ladder.model.frame.Input;

public class Results extends Input<ResultName> {
    private static final String PLAYERS_RESULTS_NUMBER_ERROR = "플레이어수와 결과수가 다릅니다.";

    public Results(String input, int playerNumbers) {
        super(input);
        addResultNames(input);
        checkValidNumbers(playerNumbers);
    }

    private void checkValidNumbers(int playerNumbers) {
        if (names.size() != playerNumbers) {
            throw new IllegalArgumentException(PLAYERS_RESULTS_NUMBER_ERROR);
        }
    }

    public ResultName getResultNameByIndex(int index) {
        return this.names.get(index);
    }

    private void addResultNames(String input) {
        for(String name : input.split(DELIMITER)){
            names.add(new ResultName(name.trim()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(ResultName resultName : names){
            sb.append(resultName.toString());
        }
        return sb.toString();
    }
}
