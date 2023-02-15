package ladder.domain;

public class Direction {
    private final Bar leftBar;
    private final Bar rightBar;

    private Direction(Bar leftBar, Bar rightBar) {
        this.leftBar = leftBar;
        this.rightBar = rightBar;
    }

    public static Direction createFirst(BarGenerator barGenerator) {
        return new Direction(new Bar(() -> false), new Bar(barGenerator));
    }

    public Direction createNext(BarGenerator barGenerator) {
        Bar newNextLeftBar = rightBar;
        if (rightBar.isExistBar()) {
            return new Direction(newNextLeftBar, new Bar(() -> false));
        }
        return new Direction(newNextLeftBar, new Bar(barGenerator));
    }

    public Direction createFinal() {
        Bar newNextLeftBar = rightBar;
        return new Direction(newNextLeftBar, new Bar(() -> false));
    }

    public boolean isExistLeftBar() {
        return leftBar.isExistBar();
    }

    public boolean isExistRightBar() {
        return rightBar.isExistBar();
    }
}
