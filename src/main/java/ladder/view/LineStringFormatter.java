package ladder.view;

import ladder.dto.LineDto;

public class LineStringFormatter {
    private static final String VERTICAL_CHAR = "|";
    private static final String HORIZONTAL_CHAR = "-";
    private static final String EMPTY_SPACE = " ";
    private static final int PATH_WIDTH = 5;

    private LineStringFormatter() {
    }

    public static String create(LineDto lineDto) {
        StringBuilder sb = new StringBuilder();
        lineDto.getConnected()
                .forEach(val -> sb.append(convertLine(val)));
        sb.append(VERTICAL_CHAR + "\n");
        return sb.toString();
    }

    private static String convertLine(boolean connected) {
        if (connected) {
            return VERTICAL_CHAR + HORIZONTAL_CHAR.repeat(PATH_WIDTH);
        }
        return VERTICAL_CHAR + EMPTY_SPACE.repeat(PATH_WIDTH);
    }
}
