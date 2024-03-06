package domain;

public class EndingSelecter {

    private static final String ENDING_WORD = "all";

    private final String value;

    public EndingSelecter(String value) {
        this.value = value;
    }

    public boolean isNotEnd() {
        return !value.equalsIgnoreCase(ENDING_WORD);
    }
}
