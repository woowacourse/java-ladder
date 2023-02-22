package ladder.exception;

public class NoSuchPlayerException extends CustomException {

    private static final String MESSAGE = "해당 플레이어는 사다리 게임에 참여하지 않았습니다.";

    public NoSuchPlayerException() {
        super(MESSAGE);
    }
}
