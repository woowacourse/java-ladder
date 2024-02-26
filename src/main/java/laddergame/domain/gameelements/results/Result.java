package laddergame.domain.gameelements.results;

import laddergame.domain.gameelements.Element;

public class Result extends Element {
    private static String result;

    public Result(String result) {
        super(result);
        Result.result = super.getElement();
    }

    public String getResult() {
        return result;
    }
}
