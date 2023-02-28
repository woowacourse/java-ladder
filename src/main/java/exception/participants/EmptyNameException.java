package exception.participants;

public class EmptyNameException extends IllegalArgumentException {

    public EmptyNameException() {
        super("입력 안된 이름이 존재합니다. 모든 이름을 입력해주세요");
    }
}
