package dto;

import java.util.Collections;
import java.util.List;

public record LadderRowDto(List<Boolean> rowPattern) {

    @Override
    public List<Boolean> rowPattern() {
        return Collections.unmodifiableList(rowPattern);
    }
}
