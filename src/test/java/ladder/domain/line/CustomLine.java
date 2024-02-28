package ladder.domain.line;

import ladder.domain.direction.Direction;

public class CustomLine {

    private final Line customLine;

    public CustomLine() {
        this.customLine = new Line();
    }

    public void addCustomDirection(Direction direction) {
        this.customLine.addDirection(direction);
    }

    public Line getLine() {
        return this.customLine;
    }
}
