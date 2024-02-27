package domain.ladder.message;

import domain.ladder.LadderHeight;

public class LadderExceptionMessage {
    public static final String LADDER_HEIGHT_RANGE = String.format("사다리 높이의 범위는 %d 이상, %d 이하여야 합니다",
            LadderHeight.HEIGHT_MIN_RANGE, LadderHeight.HEIGHT_MAX_RANGE);
    public static final String SERIAL_LADDER_BRIDGE = "사다리의 가로 라인에 연속되는 다리가 올 수 없습니다";
    public static final String NOT_FOUND_BRIDGE = "존재하지 않는 Bridge 입니다";
}
