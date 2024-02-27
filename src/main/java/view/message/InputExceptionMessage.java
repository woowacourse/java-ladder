package view.message;

import controller.RetryHandler;
import view.InputView;

public class InputExceptionMessage {

    public static final String PLAYER_NAMES_INPUT_FORMAT = String.format("참가자 이름은 %s로 구분하여 입력해야합니다",
            InputView.INPUT_DELIMITER);
    public static final String LADDER_RESULT_INPUT_FORMAT = String.format("실행 결과는 %s로 구분하여 입력해야합니다",
            InputView.INPUT_DELIMITER);

    public static final String INTEGER_FORMAT = "정수 형태만 입력 가능합니다";
    public static final String READ_LIMIT_OVER = String.format("입력 횟수 제한(%d)를 초과하였습니다", RetryHandler.READ_LIMIT);
}
