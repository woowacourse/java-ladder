package ladder.model.frame;

import ladder.model.PlayerName;

import java.util.ArrayList;
import java.util.List;

public class Input<T> {
    private static final String VALID_INPUT_ERROR = "입력 형식 오류";
    private static final String INPUT_REGEX = "^([^,]+)(,[^,]+)*$";
    protected static final String DELIMITER = ",";

    protected List<T> names;

    protected Input(String input){
        names = new ArrayList<>();
        checkValidInput(input);
    }

    private void checkValidInput(String input) {
        if(!input.matches(INPUT_REGEX)){
            throw new IllegalArgumentException(VALID_INPUT_ERROR);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(T name : names){
            sb.append(name.toString());
        }
        return sb.toString();
    }
}
