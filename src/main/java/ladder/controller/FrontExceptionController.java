package ladder.controller;

import ladder.domain.exception.CustomException;
import ladder.domain.exception.LadderLengthException;
import ladder.domain.exception.NoSuchPlayerException;
import ladder.domain.exception.NotIntegerException;
import ladder.domain.exception.PlayerNameLengthException;
import ladder.domain.exception.PlayerNumberException;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class FrontExceptionController {

    private static final String MESSAGE_PREFIX = "[ERROR]";

    private static final Map<Class<? extends CustomException>, String> messageSelector = new HashMap<>();

    public FrontExceptionController() {
        init();
    }

    private void init() {
        messageSelector.put(LadderLengthException.class, MESSAGE_PREFIX + "사다리의 길이는 <플레이어 수 - 1> 이상이어야 합니다.");
        messageSelector.put(PlayerNameLengthException.class, MESSAGE_PREFIX + "플레이어 이름의 길이는 1이상 5이하 입니다.");
        messageSelector.put(NotIntegerException.class, MESSAGE_PREFIX + "입력된 값은 정수가 아닙니다.");
        messageSelector.put(PlayerNumberException.class, MESSAGE_PREFIX + "플레이어 수는 두 명 이상이어야 합니다.");
        messageSelector.put(NoSuchPlayerException.class, MESSAGE_PREFIX + "해당하는 플레이어를 찾을 수 없습니다.");
    }

    public void handle(CustomException e) {
        OutputView.printExceptionMessage(messageSelector.get(e.getClass()));
    }
}
