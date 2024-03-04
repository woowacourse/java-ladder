package dto;

import java.util.List;
import model.result.Results;

public record ResultsDto(List<ResultDto> personAndItemName) {
    public static ResultsDto from(final Results results) {
        List<ResultDto> resultDtos = results.getResults()
                .stream()
                .map(ResultDto::from)
                .toList();
        return new ResultsDto(resultDtos);
    }
}
