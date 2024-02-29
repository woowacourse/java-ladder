package ladder.utils;

public enum Command {
    EXPRESSION_OF_ALL_PLAYER("all");

    private final String expression;

    Command(final String expression) {
        this.expression = expression;
    }

    public boolean isMatch(final String name) {
        return this.expression.equals(name);
    }
}
