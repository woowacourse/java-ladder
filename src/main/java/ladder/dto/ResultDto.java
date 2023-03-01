package ladder.dto;

public class ResultDto {
    private final String name;
    private final String result;

    public ResultDto(String name, String result) {
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
