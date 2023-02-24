package domain;

public enum Command {
    CONTINUE, END;

    public boolean isContinue() {
        return this == CONTINUE;
    }
}
