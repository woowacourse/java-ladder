package exception.ladder;

public class GameEndReservedWordException extends IllegalArgumentException {

    public GameEndReservedWordException() {
        super("게임 종료 예악어는 사용할 수 없습니다. 다시 입력해주세요.");
    }
}
