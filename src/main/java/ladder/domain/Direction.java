package ladder.domain;

public class Direction {
    private Bar leftBar;
    private Bar rightBar;

    private Direction(Bar leftBar, Bar rightBar) {
        this.leftBar = leftBar;
        this.rightBar = rightBar;
    }

    public static Direction createFirst(BarGenerator barGenerator) {
        return new Direction(new Bar(() -> false), new Bar(barGenerator));
    }

    public static Direction createMiddle(Bar leftBar, BarGenerator barGenerator) {
        if (leftBar.isExistBar()) {
            return new Direction(leftBar, new Bar(() -> false));
        }

        return new Direction(leftBar, new Bar(barGenerator));
    }

    public static Direction createFinal(Bar leftBar) {
        return new Direction(leftBar, new Bar(() -> false));
    }

    public boolean isExistLeftBar() {
        return leftBar.isExistBar();
    }

    public boolean isExistRightBar() {
        return rightBar.isExistBar();
    }
}
