package ladder.domain;

public class Player extends LadderItem {
    private static final String FORBIDDEN_NAME = "all";

    public Player(final String name) {
        super(name);
        checkIfForbidden(name);
    }

   private void checkIfForbidden(String name) {
        if (name.equals(FORBIDDEN_NAME)) {
            throw new IllegalArgumentException("플레이어 이름에는 all이 입력될 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
