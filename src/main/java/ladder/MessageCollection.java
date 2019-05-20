package ladder;

import ladder.validator.InputLadderHeightValidator;
import ladder.validator.PlayerValidator;

public class MessageCollection {

    public static final String INPUT_PLAYER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";
    public static final String INPUT_LADDER_GOAL_NAME = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.)";
    public static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String INPUT_FIND_NAME = "결과를 보고 싶은 사람은?";

    public static final String OUTPUT_LADDER_RESULT = "사다리 결과";
    public static final String OUTPUT_RESULT = "실행결과";

    public static final String ERROR_OVERLENGTH = String.format("ERROR : 이름의 길이는 %d자를 넘을 수 없습니다.", PlayerValidator.MAX_NAME_LENGTH);
    public static final String ERROR_HAS_VALUE_EMPTY = "ERROR : 입력값은 공백이 될 수 없습니다.";
    public static final String ERROR_ONE_PLAYER = "ERROR : 한명의 플레이어로는 게임을 진행 할 수 없습니다.";
    public static final String ERROR_OVERLAP_PLAYERS = "ERROR : 중복된 플레이어가 있습니다.";

    public static final String ERROR_LOWER_MIN_HEIGHT = String.format("ERROR : 사다리의 높이는 %d 이상의 수입니다.", InputLadderHeightValidator.MIN_HEIGHT);
    public static final String ERROR_NOT_INTEGER = "ERROR : 높이 입력값이 잘못 되었습니다.";

    public static final String ERROR_MISMATCH_PLAYERS_AND_GOALS = "ERROR : 참여자의 수와 실행 결과의 수가 같지 않습니다.";
    public static final String ERROR_OVERLAP_GOAL_NAME = "ERROR : 중복된 실행 결과가 있습니다.";

    public static final String ERROR_PLAYER_NOT_EXIST = "ERROR : 플레이어가 존재하지 않습니다.";

    public static final String PIPE = "|";
    public static final String HYPHEN = "-";
    public static final String BLANK = " ";
}
