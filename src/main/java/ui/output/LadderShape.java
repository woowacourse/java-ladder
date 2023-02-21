package ui.output;

import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 15.
 */
public enum LadderShape {
    WALL("|"), CONNECT("-"), DISCONNECT(" ");

    LadderShape(String shape) {
        this.shape = shape;
    }

    private final String shape;

    public static StringBuilder getLineForm(List<Boolean> points, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateFirstWall(maxLength));
        for (boolean point : points) {
            appendLineForm(point, stringBuilder, maxLength);
        }
        return stringBuilder;
    }

    private static StringBuilder generateFirstWall(int maxLength) {
        StringBuilder firstWall = new StringBuilder(WALL.shape);
        while (firstWall.length() < maxLength) {
            firstWall = new StringBuilder(" " + firstWall);
        }
        return firstWall;
    }

    private static void appendLineForm(boolean point, StringBuilder stringBuilder, int maxLine) {
        if (point) {
            stringBuilder.append(generateConnectLine(maxLine)).append(WALL.shape);
            return;
        }
        stringBuilder.append(generateDisconnectLine(maxLine)).append(WALL.shape);
    }

    private static String generateConnectLine(int maxLength) {
        return CONNECT.shape.repeat(maxLength);
    }

    private static String generateDisconnectLine(int maxLength) {
        return DISCONNECT.shape.repeat(maxLength);
    }
}
