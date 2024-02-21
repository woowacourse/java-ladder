package common.exception.message;

import domain.PlayerNames;

public class ExceptionMessage {

    public static final String PLAYER_NAMES_RANGE_ERROR = String.format("참가자의 수는 %d 이상, %d 이하여야 합니다", PlayerNames.PLAYER_NAMES_MIN_RANGE, PlayerNames.PLAYER_NAMES_MAX_RANGE);
}
