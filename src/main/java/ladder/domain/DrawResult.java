package ladder.domain;

public class DrawResult {
    private final String result;

    public DrawResult(String result) {
        checkBlank(result);
        this.result = result;
    }

    private void checkBlank(String result) {
        if (result.equals("")) {
            throw new IllegalArgumentException();
        }
    }
}
