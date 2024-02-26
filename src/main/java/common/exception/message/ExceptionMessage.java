package common.exception.message;

import controller.RetryableController;
import domain.LadderHeight;
import domain.LadderResult;
import domain.PlayerName;
import domain.PlayerNames;
import view.InputView;

public class ExceptionMessage {

    /**
     * ValidationException
     */
    public static final String PLAYER_NAMES_RANGE = String.format("참가자의 수는 %d 이상, %d 이하여야 합니다",
            PlayerNames.PLAYER_NAMES_MIN_RANGE, PlayerNames.PLAYER_NAMES_MAX_RANGE);
    public static final String PLAYER_NAMES_DUPLICATION = "참가자 이름은 중복될 수 없습니다";
    public static final String PLAYER_NAME_BLANK = "참가자 이름으로 공백을 사용할 수 없습니다";
    public static final String PLAYER_NAME_LENGTH = String.format("참가자 이름의 길이는 %d 이상, %d 이하여야 합니다",
            PlayerName.PLAYER_NAME_MIN_LENGTH, PlayerName.PLAYER_NAME_MAX_LENGTH);
    public static final String PLAYER_NAMES_FORMAT = String.format("참가자 이름은 문자(영어 or 한글)이어야 하며 %s로 구분하여 입력해야합니다",
            InputView.PLAYER_NAMES_INPUT_DELIMITER);
    public static final String LADDER_HEIGHT_RANGE = String.format("사다리 높이의 범위는 %d 이상, %d 이하여야 합니다",
            LadderHeight.HEIGHT_MIN_RANGE, LadderHeight.HEIGHT_MAX_RANGE);
    public static final String SERIAL_LADDER_BRIDGE = "한 층 내에서 사디리의 다리는 연속될 수 없습니다";
    public static final String LADDER_RESULTS_SIZE = "사다리 실행 결과의 수는 참가자의 수와 같아야 합니다";
    public static final String LADDER_RESULT_BLANK = "사다리 실행 결과는 공백일 수 없습니다";
    public static final String LADDER_RESULT_NULL = "사다리 실행 결과는 Null 일 수 없습니다";
    public static final String LADDER_RESULT_LENGTH = String.format("사다리 실행 결과의 길이는 %d 이상, %d 이하여야 합니다",
            LadderResult.LADDER_RESULT_LENGTH_MIN, LadderResult.LADDER_RESULT_LENGTH_MAX);
    public static final String LADDER_RESULT_FORMAT = String.format("사다리 실행 결과는 %s로 구분하여 입력해야합니다",
            InputView.LADDER_RESULTS_INPUT_DELIMITER);

    /**
     * NotFoundException
     */
    public static final String NOT_FOUND_BRIDGE = "존재하지 않는 Bridge 입니다";
    public static final String NOT_FOUND_LADDER_RESULT = "존재하지 않는 사다리 실행 결과입니다";

    /**
     * IOException
     */
    public static final String INTEGER_FORMAT = "정수 형태만 입력 가능합니다";
    public static final String READ_LIMIT_OVER = String.format("입력 횟수 제한(%d)를 초과하였습니다", RetryableController.READ_LIMIT);
}
