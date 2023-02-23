package ladder.dto;

import java.util.Map;

public class ResultDto {

    private final Map<String, String> results;

    public ResultDto(Map<String, String> results) {
        this.results = results;
    }

    public Map<String, String> getResults() {
        return results;
    }
}
