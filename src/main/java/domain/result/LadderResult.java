package domain.result;

public class LadderResult {

    private final String name;
    private final String result;

    public LadderResult(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getName() {
        return name;
    }
}

