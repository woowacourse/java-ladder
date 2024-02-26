package laddergame.domain.gameelements.results;

import laddergame.domain.gameelements.Element;

public class Result extends Element {
    public Result(String result) {
        super(result);
    }

    public String getResult() {
        return super.getElement();
    }
}
