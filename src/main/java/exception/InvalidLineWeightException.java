package exception;

public class InvalidLineWeightException extends IllegalArgumentException {

    public InvalidLineWeightException() {
        super("사다리의 라인은 1개에서 9개까지 생성 될 수 있습니다.(참가자가 10명 이하여야 합니다.)");
    }
}
