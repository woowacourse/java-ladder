package ui.output;

import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 15.
 */
public enum LadderShape {
    WALL("|"), FIRST_WALL("    |"), CONNECT("-----"), DISCONNECT("     ");

    LadderShape(String shape) {
        this.shape = shape;
    }

    private final String shape;

    public static StringBuilder getLineForm(List<Boolean> points) {
        StringBuilder sb = new StringBuilder();
        sb.append(FIRST_WALL.shape);
        for (boolean point : points) {
            appendLineForm(point, sb);
        }
        return sb;
    }

    private static void appendLineForm(boolean point, StringBuilder sb) {
        if (point) {
            sb.append(CONNECT.shape).append(WALL.shape);
            return;
        }
        sb.append(DISCONNECT.shape).append(WALL.shape);
    }
}
