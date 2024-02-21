package ladder.view;

import ladder.dto.LineDto;

public class LineStringFormatter {
    public static String create(LineDto lineDto) {
        StringBuilder sb = new StringBuilder();
        lineDto.getConnected()
                .forEach(val -> sb.append(convertLine(val)));
        sb.append("|\n");
        return sb.toString();
    }

    // TODO: 상수 포장하기
    private static String convertLine(boolean value) {
        if (value) {
            return "|-----";
        }
        return "|     ";
    }
}
