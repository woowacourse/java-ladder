package laddergame.domain.gameelements.results;

import laddergame.domain.gameelements.Element;

public class Result extends Element {
    private final String result;

    public Result(String result) {
        super(result);
        this.result = super.getElement();
    }

    public String getResult() {
        return result;
    }
}
