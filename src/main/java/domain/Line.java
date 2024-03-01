package domain;

import util.LineItemGenerator;
import view.LineItem;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<LineItem> lineItems;
    private final int columnLength;

    public Line(int columnLength) {
        this.lineItems = new ArrayList<>();
        this.columnLength = columnLength;
    }

    public List<LineItem> makeLine(LineItemGenerator lineItemGenerator) {
        for (int position = 0; position < columnLength - 1; position++) {
            LineItem lineItem = lineItemGenerator.generate();

            lineItems.add(decideLineItem(position, lineItem));
        }

        return lineItems;
    }

    public LineItem decideLineItem(int position, LineItem lineItem) {
        if (position == 0 || !getLineItemByPosition(position - 1).isConnected()) {
            return lineItem;
        }

        return LineItem.UNCONNECTED;
    }

    public int move(int position) {
        if (isMovableToLeft(position)) {
            return position - 1;
        }

        if (isMovableToRight(position)) {
            return position + 1;
        }

        return position;
    }

    private boolean isMovableToLeft(int position) {
        return position > 0 && getLineItemByPosition(position - 1).isConnected();
    }

    private boolean isMovableToRight(int position) {
        return position < lineItems.size() && getLineItemByPosition(position).isConnected();
    }

    private LineItem getLineItemByPosition(int position) {
        return lineItems.get(position);
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }
}
