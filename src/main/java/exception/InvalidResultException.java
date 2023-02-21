package exception;

public class InvalidResultException extends IllegalArgumentException {

    public InvalidResultException() {
        super("사다리 결과는 1자이상 5자이하 입니다.");
    }
}
