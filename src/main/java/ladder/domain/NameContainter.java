package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class NameContainter {
    private static final String DELIMITER = ",";
    private static final String VALID_INPUT_ERROR = "입력 형식 오류";
    private static final String PLAYERNAMES_INPUT_REGEX = "^([^,]+)(,[^,]+)*$";

    protected List<Name> names;

    public NameContainter(String input) {
        names = new ArrayList<>();
        checkValidInput(input);
        addNames(input);
    }

    private void checkValidInput(String input) {
        if(!input.matches(PLAYERNAMES_INPUT_REGEX)){
            throw new IllegalArgumentException(VALID_INPUT_ERROR);
        }
    }

    public abstract void add(String name);

    protected void addNames(String input) {
        for (String name : input.split(DELIMITER)) {
            this.add(name);
        }
    };

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Name name : names){
            sb.append(String.format("%6s", name.toString()));
        }
        return sb.toString();
    }
}
