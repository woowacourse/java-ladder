package ladder.domain;

public enum LineSource {
    MAKE_LINE(true),
    MAKE_BLANK(false);

    private boolean makeLineTo;


    LineSource(boolean value) {
        this.makeLineTo = value;
    }

    public boolean makeLine(){
        return makeLineTo;
    }
}
