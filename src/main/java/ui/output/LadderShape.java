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

    public static String getLadderForm(List<Boolean> points, int maxNameLength) {
        StringBuilder sb = new StringBuilder();
        for (Boolean point : points) {
            sb.append(appendLadder(point, maxNameLength));
        }
        return sb.toString();
    }

    private static StringBuilder appendLadder(Boolean point, int maxNameLength) {
        StringBuilder sb = new StringBuilder();
        if (point) {
            sb.append(CONNECT.shape.repeat(maxNameLength)).append(WALL.shape);
            return sb;
        }
        return sb.append(DISCONNECT.shape.repeat(maxNameLength)).append(WALL.shape);
    }
}
