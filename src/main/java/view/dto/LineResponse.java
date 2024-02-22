package view.dto;

import model.LadderElement;
import model.Line;

public class LineResponse {

    private final String value;

    private LineResponse(String value) {
        this.value = value;
    }

    public static LineResponse from(Line line) {
        StringBuilder result = new StringBuilder();
        result.append(LadderElement.COLUMN.getSymbol());
        for (int index = 0; index < line.size(); index++) {
            result.append(getElement(line.hasBridge(index)));
            result.append(LadderElement.COLUMN.getSymbol());
        }
        return new LineResponse(result.toString());
    }

    private static String getElement(boolean hasBridge) {
        if (hasBridge) {
            return LadderElement.ROW.getSymbol();
        }
        return LadderElement.EMPTY.getSymbol();
    }

    public String getValue() {
        return value;
    }
}
