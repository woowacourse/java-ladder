package ui.output;

import domain.ConnectStatus;
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

    public static StringBuilder getLineForm(List<ConnectStatus> points, int maxLength) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(generateFirstWall(maxLength));
        for (ConnectStatus point : points) {
            appendLineForm(point.status(), stringBuilder, maxLength);
            stringBuilder.append(WALL.shape);
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

    private static void appendLineForm(boolean isConnected, StringBuilder stringBuilder, int maxLine) {
        if (isConnected) {
            stringBuilder.append(generateConnectLine(maxLine));
            return;
        }
        stringBuilder.append(generateDisconnectLine(maxLine));
    }

    private static String generateConnectLine(int maxLength) {
        return CONNECT.shape.repeat(maxLength);
    }

    private static String generateDisconnectLine(int maxLength) {
        return DISCONNECT.shape.repeat(maxLength);
    }
}
