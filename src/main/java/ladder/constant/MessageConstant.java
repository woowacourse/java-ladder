package ladder.constant;

import ladder.model.Player;

public class MessageConstant {
    public static final String ERROR_OVERLENGTH = String.format("이름의 길이는 %d자를 넘을 수 없습니다.", Player.MAX_NAME_LENGTH);
    public  static final String ERROR_HASEMPTY = "이름은 공백이 될 수 없습니다.";
}
