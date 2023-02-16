package model;

public class FakeHeight extends Height {

    private static final int MINIMUM_HEIGHT_VALUE = 1;

    public FakeHeight() {
        super(MINIMUM_HEIGHT_VALUE);
    }

    @Override
    public boolean isContinueMakeLadder() {
        super.isContinueMakeLadder();
        return super.isContinueMakeLadder();
    }
}
