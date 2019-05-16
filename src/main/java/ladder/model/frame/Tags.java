package ladder.model.frame;


import ladder.model.Tag;

import java.util.ArrayList;
import java.util.List;

public abstract class Tags {
    private static final String NOT_VALID_INPUT_ERROR = "입력 형식 오류";
    private static final String INPUT_REGEX = "^([^,]+)(,[^,]+)*$";
    protected static final String DELIMITER = ",";

    protected List<Tag> tags;

    protected Tags(String input) {
        tags = new ArrayList<>();
        checkValidInput(input);
    }

    private void checkValidInput(String input) {
        if (!input.matches(INPUT_REGEX)) {
            throw new IllegalArgumentException(NOT_VALID_INPUT_ERROR);
        }
    }

    protected abstract void addTags(String tag);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Tag tag : tags) {
            sb.append(String.format("%6s", tag.getValue()));
        }
        return sb.toString();
    }
}
