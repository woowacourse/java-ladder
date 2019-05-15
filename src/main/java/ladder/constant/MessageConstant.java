package ladder.constant;

import ladder.model.Player;

public class MessageConstant {

    public static final String INPUT_PLAYER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";

    public static final String ERROR_OVERLENGTH = String.format("ERROR : 이름의 길이는 %d자를 넘을 수 없습니다.", Player.MAX_NAME_LENGTH);
    public static final String ERROR_HASEMPTY = "ERROR : 이름은 공백이 될 수 없습니다.";
    public static final String ERROR_ONE_PLAYER = "ERROR : 한명의 플레이어로는 게임을 진행 할 수 없습니다.";
    public static final String ERROR_OVERLAP_PLAYERS = "ERROR : 중복된 플레이어가 있습니다.";
}
