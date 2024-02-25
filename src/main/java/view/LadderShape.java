package view;

import domain.LadderItem;

import java.util.Arrays;

public enum LadderShape {

    CONNECTED(LadderItem.CONNECTED, "-----|"),
    UNCONNECTED(LadderItem.UNCONNECTED, "     |");

    private final LadderItem ladderItem;
    private final String shape;

    LadderShape(LadderItem ladderItem, String shape) {
        this.ladderItem = ladderItem;
        this.shape = shape;
    }

    public static String getShapeByLadderItem(LadderItem ladderItem) {
        return Arrays.stream(LadderShape.values())
                .filter(shape -> shape.ladderItem.equals(ladderItem))
                .findAny()
                .orElseThrow()
                .shape;
    }
}
