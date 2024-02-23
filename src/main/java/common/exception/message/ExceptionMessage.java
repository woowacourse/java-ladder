package common.exception.message;

import controller.Controller;
import domain.LadderHeight;
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
    public static final String LADDER_HEIGHT_RANGE = String.format("사다리 높이의 범위는 %d 이상, %d 이하여야 합니다",
            LadderHeight.HEIGHT_MIN_RANGE, LadderHeight.HEIGHT_MAX_RANGE);
    public static final String SERIAL_BRIDGE = "사다리의 가로 라인에 연속되는 다리가 올 수 없습니다";

    /**
     * NotFoundException
     */
    public static final String NOT_FOUND_BRIDGE = "존재하지 않는 Bridge 입니다";

    /**
     * IOException
     */
    public static final String INTEGER_FORMAT = "정수 형태만 입력 가능합니다";
    public static final String PLAYER_NAMES_INPUT_FORMAT = String.format("참가자 이름은 %s로 구분하여 입력해야합니다",
            InputView.PLAYER_NAMES_INPUT_DELIMITER);
    public static final String READ_LIMIT_OVER = String.format("입력 횟수 제한(%d)를 초과하였습니다", Controller.READ_LIMIT);
}
