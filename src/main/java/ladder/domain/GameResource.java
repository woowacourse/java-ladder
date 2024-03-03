package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.prize.Prizes;
import ladder.domain.user.Users;

public class GameResource {

    public static final String RESOURCE_NAME_USERS = "사용자";
    public static final String RESOURCE_NAME_PRIZES = "당첨품";
    public static final String RESOURCE_NAME_LADDER = "사다리";

    private Users users;
    private Prizes prizes;
    private Ladder ladder;

    public void add(Users users, Prizes prizes, Ladder ladder) {
        validateResourceAlreadyExist();
        validateResourceNotNull(users, RESOURCE_NAME_USERS);
        validateResourceNotNull(prizes, RESOURCE_NAME_PRIZES);
        validateResourceNotNull(ladder, RESOURCE_NAME_LADDER);

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

    private void validateResourceNotNull(Object valueToAdd, String resourceName) {
        if (valueToAdd == null) {
            String errorMessage = String.format("[ERROR] 게임 리소스에 추가할 %s가(이) 존재하지 않습니다.", resourceName);
            throw new IllegalArgumentException(errorMessage);
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
