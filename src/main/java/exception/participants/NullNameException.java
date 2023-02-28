package exception.participants;

public class NullNameException extends IllegalArgumentException {

    public NullNameException() {
        super("존재하지 않는 참가자입니다. 다시 입력해주세요.");
    }
}
