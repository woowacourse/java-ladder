package exception.ladder;

public class InvalidLadderResultCount extends IllegalArgumentException {

    public InvalidLadderResultCount() {
        super("참가자 수랑 동일한 갯수의 사다리 결과를 입력해주세요.");
    }
}
