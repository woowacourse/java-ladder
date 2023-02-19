package exception;

public class DuplicateNameException extends IllegalArgumentException {

    public DuplicateNameException() {
        super("중복되는 이름이 존재합니다. 다시 입력해주세요");
    }
}
