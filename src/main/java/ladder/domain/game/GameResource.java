package ladder.domain.game;

import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.prize.Prizes;
import ladder.domain.resource.user.Users;

public class GameResource {

    private static final String SYSTEM_ERROR_ALREADY_EXIST = "[ERROR] 게임 리소스에 %s가(이) 이미 존재하는 경우 변경할 수 없습니다.";
    private static final String SYSTEM_ERROR_ADD_NULL = "[ERROR] 게임 리소스에 추가할 %s가(이) 존재하지 않습니다.";
    private static final String RESOURCE_NAME_USERS = "사용자";
    private static final String RESOURCE_NAME_LADDER = "사다리";
    private static final String RESOURCE_NAME_PRIZES = "당첨품";


    private Users users;
    private Ladder ladder;
    private Prizes prizes;

    public void addUsers(Users users) {
        validateAlreadyExist(this.users, RESOURCE_NAME_USERS);
        validateNull(users, RESOURCE_NAME_USERS);
        this.users = users;
    }

    public void addLadder(Ladder ladder) {
        validateAlreadyExist(this.ladder, RESOURCE_NAME_LADDER);
        validateNull(ladder, RESOURCE_NAME_LADDER);
        this.ladder = ladder;
    }

    public void addPrizes(Prizes prizes) {
        validateAlreadyExist(this.prizes, RESOURCE_NAME_PRIZES);
        validateNull(prizes, RESOURCE_NAME_PRIZES);
        this.prizes = prizes;
    }


    private void validateAlreadyExist(Object existingValue, String resourceName) {
        if (existingValue != null) {
            String errorMessage = String.format(SYSTEM_ERROR_ALREADY_EXIST, resourceName);
            throw new IllegalStateException(errorMessage);
        }
    }

    private void validateNull(Object valueToAdd, String resourceName) {
        if (valueToAdd == null) {
            String errorMessage = String.format(SYSTEM_ERROR_ADD_NULL, resourceName);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public Users getUsers() {
        return users;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
