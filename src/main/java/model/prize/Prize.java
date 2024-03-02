package model.prize;

import dto.PrizeName;
import utils.Constant;

public class Prize {
    private final String prizeName;

    public Prize(String prizeName) {
        validator(prizeName);
        this.prizeName = prizeName;
    }

    private void validator(String prizeName) {
        if (prizeName == null) {
            throw new IllegalArgumentException("결과 이름은 null일 수 없다.");
        }
        if (prizeName.isEmpty() || prizeName.isBlank() || prizeName.length() > Constant.STEP_LENGTH) {
            throw new IllegalArgumentException("결과 이름은 1 ~ " + Constant.STEP_LENGTH + " 길이의 문자이어야합니다.");
        }
    }

    public String getPrizeName() {
        return prizeName;
    }

    public PrizeName convertToPrizeName() {
        return new PrizeName(prizeName);
    }
}
