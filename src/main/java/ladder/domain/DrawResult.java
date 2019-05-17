package ladder.domain;



public class DrawResult {
    private static final String BLANK = "";

    private final String result;

    public DrawResult(String result) {
        checkBlank(result);
        this.result = result;
    }

    private void checkBlank(String result) {
        if (result.equals(BLANK)) {
            throw new IllegalArgumentException();
        }
    }

    String getResult() {
        return result;
    }
}
