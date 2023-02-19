package model;

import util.ExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderResult {
    private static final String SPLIT_DELIMITER = ",";

    private List<String> ladderResult = new ArrayList<>();

    public LadderResult(String result, int personCount) {
        List<String> splitResult = splitLadderResult(result);
        validateLadderResult(splitResult,personCount);
        this.ladderResult = splitLadderResult(result);
    }

    private List<String> splitLadderResult(String result) {
        return Arrays.asList(result.split(SPLIT_DELIMITER));
    }

    private boolean validateLadderResult(List<String> result, int personCount){
        if(result.size()!=personCount || result.isEmpty()){
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_LADDER_RESULT.getExceptionMessage());
        }
        return true;
    }
}
