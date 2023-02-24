package ladder.dto;

import java.util.Collections;
import java.util.List;

public class ResultDtos {
    private final List<ResultDto> resultDtos;

    public ResultDtos(List<ResultDto> resultDtos) {
        this.resultDtos = resultDtos;
    }

    public int size() {
        return resultDtos.size();
    }
    public String getResult(int index) {
        return resultDtos.get(index).getResult();
    }

    public List<ResultDto> getResultDtos() {
        return Collections.unmodifiableList(resultDtos);
    }
}
