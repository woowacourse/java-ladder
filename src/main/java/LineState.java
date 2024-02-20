public enum LineState {
    START("start"),
    END("end"),
    NOTHING("nothing");

    private final String state;

    LineState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
