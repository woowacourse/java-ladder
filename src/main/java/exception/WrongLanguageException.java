package exception;

public class WrongLanguageException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "참여자 이름은 한글을 입력할 수 없습니다.";

    public WrongLanguageException() {
        super(DEFAULT_MESSAGE);
    }
}
