package model;

import java.util.ArrayList;
import java.util.List;

public record LadderDto(List<String> ladder) {

    private static final String CONNECTED_FORM = "-----";
    private static final String UNCONNECTED_FORM = "     ";
    private static final String SIDE_RAIL = "|";

    public static LadderDto from(List<Line> lines) {
        List<String> result = new ArrayList<>();
        for (Line line : lines) {
            result.add(formatLine(line));
        }
        return new LadderDto(result);
    }

    private static String formatLine(final Line line) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append(SIDE_RAIL);
        for (int index = 0; index < line.size(); index++) {
            lineBuilder.append(convertToLadderForm(line, index));
            lineBuilder.append(SIDE_RAIL);
        }
        return lineBuilder.toString();
    }

    private static String convertToLadderForm(final Line line, final int index) {
        if (line.getLadderStatus(index).isConnected()) {
            return CONNECTED_FORM;
        }
        return UNCONNECTED_FORM;
    }
}
