package ladder.domain;

public class Direction2 {

    private Bar leftBar;
    private Bar rightBar;

    public Direction2(Bar leftBar, BarGenerator barGenerator) {
        this.leftBar = leftBar;
        this.rightBar = new Bar(barGenerator);
    }
}
