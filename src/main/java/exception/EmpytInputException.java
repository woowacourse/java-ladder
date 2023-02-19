package exception;

public class EmpytInputException extends IllegalArgumentException {

    public EmpytInputException() {
        super("입력값이 없습니다. 다시 입력해주세요");
    }
}
