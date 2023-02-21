package exception;

public class InvalidPersonNameException extends IllegalArgumentException {

    public InvalidPersonNameException() {
        super("참가자의 이름은 1이상 5이하입니다. 다시 입력해주세요.");
    }
}
