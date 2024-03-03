package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.prize.Prizes;
import ladder.domain.user.Users;

public class GameResource {

    private Users users;
    private Prizes prizes;
    private Ladder ladder;

    public void add(Users users, Prizes prizes, Ladder ladder) {
        validateResourceAlreadyExist();
        validateResourceNotNull(users, prizes, ladder);
        this.users = users;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public boolean allFieldsNotNull() {
        return users != null && prizes != null && ladder != null;
    }

    public boolean allFieldConsistentSize() {
        return users.getSize() == prizes.getSize() && prizes.getSize() == ladder.getWidth();
    }

    private void validateResourceAlreadyExist() {
        if (allFieldsNotNull()) {
            throw new IllegalStateException("[ERROR] 게임 리소스가 이미 존재하는 경우 변경할 수 없습니다.");
        }
    }

    private void validateResourceNotNull(Users usersToAdd, Prizes prizesToAdd, Ladder ladderToAdd) {
        if (usersToAdd == null) {
            throw new IllegalArgumentException("[ERROR] 게임 리소스에 추가할 사용자가 존재하지 않습니다.");
        }
        if (prizesToAdd == null) {
            throw new IllegalArgumentException("[ERROR] 게임 리소스에 추가할 당첨품이 존재하지 않습니다.");
        }
        if (ladderToAdd == null) {
            throw new IllegalArgumentException("[ERROR] 게임 리소스에 추가할 사다리가 존재하지 않습니다.");
        }
    }

    public Users getUsers() {
        return users;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
