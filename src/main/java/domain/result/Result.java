package domain.result;

public class Result {
    private String value;

    public Result(final String value) {
        this.value = value;
    }

    public String resultToString() {
        return value;
    }
}
