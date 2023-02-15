public enum Path {
    GO(1, true),
    STOP(0, false);

    private final int goNumberValue;
    private final boolean goBooleanValue;

    Path(int goNumberValue, boolean goBooleanValue) {
        this.goBooleanValue = goBooleanValue;
        this.goNumberValue = goNumberValue;
    }

    public int getGoNumberValue() {
        return goNumberValue;
    }

    public boolean getGoBooleanValue() {
        return goBooleanValue;
    }
}
