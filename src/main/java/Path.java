public enum Path {
    GO(1, true),
    STOP(0, false);

    private final int goNumberValue;
    private final Boolean goBooleanValue;

    Path(int goNumberValue, boolean goBooleanValue) {
        this.goBooleanValue = goBooleanValue;
        this.goNumberValue = goNumberValue;
    }

    public Boolean getGoBooleanValue() {
        return goBooleanValue;
    }

    public int getGoNumberValue() {
        return goNumberValue;
    }
}
