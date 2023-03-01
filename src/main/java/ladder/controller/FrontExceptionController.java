package ladder.controller;

import ladder.domain.exception.LadderLengthException;
import ladder.domain.exception.NoSuchPlayerException;
import ladder.domain.exception.PlayerNameLengthException;
import ladder.domain.exception.PlayerNumberException;
import ladder.view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class FrontExceptionController {

    private static final String MESSAGE_PREFIX = "[ERROR]";

    private static final Map<Class<? extends RuntimeException>, String> messageSelector = new HashMap<>();

    private final OutputView outputView;

    public FrontExceptionController(OutputView outputView) {
        this.outputView = outputView;
        init();
    }

    private void init() {
        addMessage();
        addPrefix();
    }

    private void addMessage() {
        addMessageWithDomain();
        addMessageWithView();
    }

    private void addMessageWithDomain() {
        messageSelector.put(LadderLengthException.class, "사다리의 길이는 <플레이어 수 - 1> 이상이어야 합니다.");
        messageSelector.put(PlayerNameLengthException.class, "플레이어 이름의 길이는 1이상 5이하 입니다.");
        messageSelector.put(PlayerNumberException.class, "플레이어 수는 두 명 이상이어야 합니다.");
        messageSelector.put(NoSuchPlayerException.class, "해당하는 플레이어를 찾을 수 없습니다.");
    }

    private void addMessageWithView() {
        messageSelector.put(NumberFormatException.class, "입력된 값은 정수가 아닙니다.");
    }

    private void addPrefix() {
        messageSelector.forEach((k, v) -> messageSelector.put(k, MESSAGE_PREFIX + v));
    }

    public void handle(RuntimeException e) {
        outputView.printExceptionMessage(messageSelector.get(e.getClass()));
    }
}
