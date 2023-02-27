package ui.output;

import java.util.List;

public enum LadderShape {

    WALL("|"), CONNECT("-"), DISCONNECT(" "), LEFT("L"), RIGHT("R"), NONE("N");

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
