package ladder.constant;

import ladder.controller.LadderGameController;
import ladder.model.objectname.LadderGoalName;
import ladder.model.objectname.LadderPlayerName;
import ladder.validator.LadderHeightValidator;

public class MessageConstant {
    private MessageConstant() {
    }

    public static final String INPUT_LADDER_PLAYER_NAME = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)";
    public static final String INPUT_LADDER_GOAL_NAME = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.)";
    public static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
    public static final String INPUT_TARGET_NAME = "결과를 보고 싶은 사람은? (all : 전체 결과, exit : 프로그램 종료)";

    public static final String OUTPUT_LADDER_GAME_RESULT = "사다리 결과";
    public static final String OUTPUT_ACTION_RESULT = "실행 결과";

    public static final String ERROR_EXCESS_PLAYER_NAME_LENGTH
            = String.format("ERROR : 플레이어 이름의 길이는 %d자를 넘을 수 없습니다.", LadderPlayerName.MAX_LENGTH_OF_PLAYER_NAME);
    public static final String ERROR_EMPTY_VALUE = "ERROR : 입력값은 공백 등이 될 수 없습니다.";
    public static final String ERROR_LACK_OF_PLAYERS = "ERROR : 한 명의 플레이어로는 게임을 진행 할 수 없습니다.";
    public static final String ERROR_OVERLAP_PLAYERS = "ERROR : 중복된 플레이어 이름이 있습니다.";

    public static final String ERROR_BELOW_HEIGHT
            = String.format("ERROR : 사다리의 높이는 %d 이상의 수입니다.", LadderHeightValidator.MIN_HEIGHT);
    public static final String ERROR_NOT_INTEGER = "ERROR : 사다리의 높이는 정수로 입력해 주세요.";

    public static final String ERROR_EXCESS_GOAL_NAME_LENGTH
            = String.format("ERROR : 실행 결과 이름의 길이는 %d자를 넘을 수 없습니다.", LadderGoalName.MAX_LENGTH_OF_GOAL_NAME);
    public static final String ERROR_MISMATCH_NUM_OF_PLAYERS_AND_GOALS = "ERROR : 참여자의 수와 실행 결과의 수가 같지 않습니다.";
    public static final String ERROR_OVERLAP_GOALS = "ERROR : 중복된 실행 결과가 있습니다.";

    public static final String ERROR_PLAYER_NOT_EXIST = "ERROR : 플레이어가 존재하지 않습니다.";

    public static final String ERROR_NULL = "ERROR : 올바르지 않은 입력입니다.";

    public static final String ERROR_RESERVED_WORD_ALL
            = LadderGameController.ALL_RESULTS + "은 게임에서 지정된 예약어입니다. 다른 이름을 사용해 주세요.";
    public static final String ERROR_RESERVED_WORD_EXIT
            = LadderGameController.EXIT_PROGRAM + "은 게임에서 지정된 예약어입니다. 다른 이름을 사용해 주세요.";
}
