package ladder.domain.game;

import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.prize.Prizes;
import ladder.domain.resource.user.Users;

public class GameResource {

    public static final String RESOURCE_NAME_USERS = "사용자";
    public static final String RESOURCE_NAME_PRIZES = "당첨품";
    public static final String RESOURCE_NAME_LADDER = "사다리";

    private Users users;
    private Prizes prizes;
    private Ladder ladder;

    public void add(Users users, Prizes prizes, Ladder ladder) {
        validateUsersToAdd(users);
        validatePrizesToAdd(prizes);
        validateLadderToAdd(ladder);

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

    private void validateUsersToAdd(Users usersToAdd) {
        validateResourceNotNull(usersToAdd, RESOURCE_NAME_USERS);
        validateResourceAlreadyExist(this.users, RESOURCE_NAME_USERS);
    }

    private void validatePrizesToAdd(Prizes prizesToAdd) {
        validateResourceNotNull(prizesToAdd, RESOURCE_NAME_PRIZES);
        validateResourceAlreadyExist(this.prizes, RESOURCE_NAME_PRIZES);
    }

    private void validateLadderToAdd(Ladder ladderToAdd) {
        validateResourceNotNull(ladderToAdd, RESOURCE_NAME_LADDER);
        validateResourceAlreadyExist(this.ladder, RESOURCE_NAME_LADDER);
    }

    private void validateResourceNotNull(Object valueToAdd, String resourceName) {
        if (valueToAdd == null) {
            String errorMessage = String.format("[ERROR] 게임 리소스에 추가할 %s가(이) 존재하지 않습니다.", resourceName);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateResourceAlreadyExist(Object existingValue, String resourceName) {
        if (existingValue != null) {
            String errorMessage = String.format("[ERROR] 게임 리소스에 %s가(이) 이미 존재하는 경우 변경할 수 없습니다.", resourceName);
            throw new IllegalStateException(errorMessage);
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
