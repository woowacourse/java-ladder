import ladder.domain.DrawnLadder;
import ladder.domain.Position;

public class Navigator {
    public static Position navigate(DrawnLadder ladder, Position from) {
        Position current = from;
        for (Position row : ladder.createFirstRowPosition().begin()) {
            current = ladder.nextColumnPosition(row, current);
        }
        return current;
    }
}
