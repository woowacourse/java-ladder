package common.exception.message;

import domain.PlayerNames;

public class ExceptionMessage {

    public static final String PLAYER_NAMES_RANGE = String.format("참가자의 수는 %d 이상, %d 이하여야 합니다",
            PlayerNames.PLAYER_NAMES_MIN_RANGE, PlayerNames.PLAYER_NAMES_MAX_RANGE);
    public static final String PLAYER_NAMES_DUPLICATION = "참가자 이름은 중복될 수 없습니다";
}
