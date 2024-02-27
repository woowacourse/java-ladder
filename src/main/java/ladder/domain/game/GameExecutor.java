package ladder.domain.game;

import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.prize.Prizes;
import ladder.domain.resource.user.Users;

public class GameExecutor {

    private static final String ERROR_NO_RESOURCE = "[ERROR] %s 정보가 없습니다.";
    private static final String ERROR_NOT_CONSISTENT_SIZE = "[ERROR] %s 수, %s 너비, %s 수는 모두 일치해야 합니다.";

    public void validateGameEnvironment(GameResource gameResource) {
        Users users = gameResource.getUsers();
        Ladder ladder = gameResource.getLadder();
        Prizes prizes = gameResource.getPrizes();

        validateResource(users, ladder, prizes);
        validateConsistentSize(users, ladder, prizes);
    }

    private void validateResource(Users users, Ladder ladder, Prizes prizes) {
        if (users == null) {
            String errorMessage = String.format(ERROR_NO_RESOURCE, GameResource.RESOURCE_NAME_USERS);
            throw new IllegalArgumentException(errorMessage);
        }

        if (ladder == null) {
            String errorMessage = String.format(ERROR_NO_RESOURCE, GameResource.RESOURCE_NAME_LADDER);
            throw new IllegalArgumentException(errorMessage);
        }

        if (prizes == null) {
            String errorMessage = String.format(ERROR_NO_RESOURCE, GameResource.RESOURCE_NAME_PRIZES);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validateConsistentSize(Users users, Ladder ladder, Prizes prizes) {
        int numberOfUsers = users.getNumberOfUsers();
        int ladderWidth = ladder.getWidth();
        int numberOfPrizes = prizes.getNumberOfPrizes();

        if (numberOfUsers != ladderWidth || ladderWidth != numberOfPrizes) {
            String errorMessage = String.format(
                    ERROR_NOT_CONSISTENT_SIZE,
                    GameResource.RESOURCE_NAME_USERS,
                    GameResource.RESOURCE_NAME_LADDER,
                    GameResource.RESOURCE_NAME_PRIZES
            );
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
