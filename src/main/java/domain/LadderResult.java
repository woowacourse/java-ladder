package domain;

public class LadderResult {

    private final String result;
    private final String name;

    public LadderResult(String result, String name) {
        this.result = result;
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public String getName() {
        return name;
    }
}

