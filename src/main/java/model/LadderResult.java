package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderResult {
    private static final String SPLIT_DELIMITER = ",";

    private List<String> ladderResult = new ArrayList<>();

    public LadderResult(String result) {
        this.ladderResult = splitLadderResult(result);
    }

    private List<String> splitLadderResult(String result) {
        return Arrays.asList(result.split(SPLIT_DELIMITER));
    }

}
