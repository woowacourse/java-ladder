package ladder.constant;

import ladder.validator.InputLadderHeightValidator;
import ladder.validator.PlayerValidator;

public class MessageConstant {

    public static final String INPUT_PLAYER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";
    public static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    public static final String OUPUT_RESULT = "실행결과\n";

    public static final String ERROR_OVERLENGTH = String.format("ERROR : 이름의 길이는 %d자를 넘을 수 없습니다.", PlayerValidator.MAX_NAME_LENGTH);
    public static final String ERROR_HAS_VALUE_EMPTY = "ERROR : 입력값은 공백이 될 수 없습니다.";
    public static final String ERROR_ONE_PLAYER = "ERROR : 한명의 플레이어로는 게임을 진행 할 수 없습니다.";
    public static final String ERROR_OVERLAP_PLAYERS = "ERROR : 중복된 플레이어가 있습니다.";

    public static final String ERROR_LOWER_MIN_HEIGHT = String.format("ERROR : 사다리의 높이는 %d 이상의 수입니다.", InputLadderHeightValidator.MIN_HEIGHT);
    public static final String ERROR_NOT_INTEGER = "ERROR : 높이 입력값이 잘못 되었습니다.";

}
