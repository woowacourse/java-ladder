package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private static final String DELIMITER = ",";
    private static final String VALID_INPUT_ERROR = "플레이어 이름들 입력 형식 오류";
    private static final String RESULTS_INPUT_REGEX = "^([^,]+)(,[^,]+)*$";

    private List<ResultName> resultNames;

    public Results(String input) {
        resultNames = new ArrayList<>();
        checkValidInput(input);
        addResultNames(input);
    }

    public List<ResultName> getResultNames() {
        return resultNames;
    }

    public int getResultNumber() {
        return resultNames.size();
    }

    public ResultName getResultName(int index) {
        return this.resultNames.get(index);
    }

    private void addResultNames(String input) {
        for(String name : input.split(DELIMITER)){
            resultNames.add(new ResultName(name.trim()));
        }
    }

    private void checkValidInput(String input) {
        if(!input.matches(RESULTS_INPUT_REGEX)){
            throw new IllegalArgumentException(VALID_INPUT_ERROR);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(ResultName resultName : resultNames){
            sb.append(resultName.toString());
        }
        return sb.toString();
    }
}
