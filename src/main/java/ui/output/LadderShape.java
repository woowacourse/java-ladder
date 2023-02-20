package ui.output;

import domain.Lines;

import java.util.List;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 20.
 */
public enum LadderShape {

    WALL("|"), CONNECT("-"), DISCONNECT(" ");

    LadderShape(String shape) {
        this.shape = shape;
    }

    private final String shape;

    public static StringBuilder getLadderForm(List<Boolean> points, int maxNameLength) {
        StringBuilder sb = new StringBuilder();
        sb.append(DISCONNECT.shape.repeat(maxNameLength - 1)).append(WALL.shape);
        for (boolean point : points) {
            appendLineForm(point, sb, maxNameLength);
        }
        return sb;
    }

    private static void appendLineForm(boolean point, StringBuilder sb, int maxNameLength) {
        if (point) {
            sb.append(CONNECT.shape.repeat(maxNameLength)).append(WALL.shape);
            return;
        }
        sb.append(DISCONNECT.shape.repeat(maxNameLength)).append(WALL.shape);
    }
}
