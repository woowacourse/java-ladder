package view;

import domain.Ladder.Ladder;
import domain.Ladder.Line;
import domain.Ladder.Point;

import java.util.stream.Collectors;

public class LadderFormatter {
    private static final String ABSENT_LINE = "     ";
    private static final String PRESENT_LINE = "-----";
    private static final String LADDER_DELIMITER = "|";
    private static final String PREFIX = "     |";
    private static final String SUFFIX = "|";
    
    public static String formatLadder( Ladder ladder ) {
        return ladder.getLines().stream()
                .map(LadderFormatter::formatLine)
                .collect(Collectors.joining(System.lineSeparator()));
    }
    
    public static String formatLine( Line line ) {
        return line.getPoints().stream()
                .map(LadderFormatter::formatPoint)
                .collect(Collectors.joining(LADDER_DELIMITER, PREFIX, SUFFIX));
    }
    
    public static String formatPoint( Point point ) {
        if ( point.isPresent() ) {
            return PRESENT_LINE;
        }
        return ABSENT_LINE;
    }
}
