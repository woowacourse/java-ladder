package exception;

public class NotEnglishAndNumberException extends IllegalArgumentException {

    public NotEnglishAndNumberException() {
        super("영어와 숫자로만 이루어져야 합니다. 다시 입력해 주세요.");
    }
}
