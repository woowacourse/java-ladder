package engine.model;

public class ResultModel {

    private final String name;
    private final String result;

    public ResultModel(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
