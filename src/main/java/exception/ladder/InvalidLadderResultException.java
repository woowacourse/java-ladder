package exception.ladder;

public class InvalidLadderResultException extends IllegalArgumentException {

    public InvalidLadderResultException() {
        super("사다리 결과는 1자이상 5자이하 입니다.");
    }
}
