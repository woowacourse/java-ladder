package domain.player.message;

import domain.player.PlayerNames;

public class PlayerExceptionMessage {

    public static final String PLAYER_NAMES_RANGE = String.format("참가자의 수는 %d 이상, %d 이하여야 합니다",
            PlayerNames.PLAYER_NAMES_MIN_RANGE, PlayerNames.PLAYER_NAMES_MAX_RANGE);
    public static final String PLAYER_NAMES_DUPLICATION = "참가자 이름은 중복될 수 없습니다";
    public static final String PLAYER_NAME_BLANK = "참가자 이름으로 공백을 사용할 수 없습니다";
    public static final String PLAYER_NAME_LENGTH = String.format("참가자 이름은 1글자 이상 5글자 이하여야 합니다.");
}
