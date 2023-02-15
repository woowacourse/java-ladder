package ui.output;

import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 15.
 */
public enum LadderShape {
    WALL("|"), CONNECT("-----"), DISCONNECT("     ");

    LadderShape(String shape) {
        this.shape = shape;
    }

    private final String shape;

    public static StringBuilder getLineForm(List<Boolean> points) {
        StringBuilder sb = new StringBuilder();
        sb.append("    |");
        for (boolean point : points) {
            if (point) {
                sb.append(CONNECT.shape).append(WALL.shape);
            } else {
                sb.append(DISCONNECT.shape).append(WALL.shape);
            }
        }
        return sb;
    }
}
