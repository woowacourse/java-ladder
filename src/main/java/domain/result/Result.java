package domain.result;

public class Result {
    private final String name;

    public Result(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {

    }

}
