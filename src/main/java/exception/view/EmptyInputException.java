package exception.view;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException() {
        super("입력값이 없습니다. 다시 입력해주세요");
    }
}
