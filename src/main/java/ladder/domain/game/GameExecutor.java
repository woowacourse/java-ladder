package ladder.domain.game;

import ladder.domain.resource.direction.Direction;
import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.line.Line;
import ladder.domain.resource.prize.Prize;
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

    public void execute(GameResource gameResource, GameResult gameResult) {
        Users users = gameResource.getUsers();
        Ladder ladder = gameResource.getLadder();
        Prizes prizes = gameResource.getPrizes();

        for (int i = 0; i < users.getSize(); i++) {
            int position = i;
            position = climbLadder(ladder, position);
            Prize prize = prizes.getPrizeByIndex(position);
            gameResult.save(users.getUserByIndex(i), prize);
        }
    }

    private int climbLadder(Ladder ladder, int position) {
        for (Line line : ladder.getLines()) {
            validatePositionWithinWidth(line, position);
            Direction direction = line.getDirectionByIndex(position);
            position += moveInDirection(direction);
        }

        return position;
    }

    private int moveInDirection(Direction direction) {
        if (direction == Direction.RIGHT) {
            return 1;
        }

        if (direction == Direction.LEFT) {
            return -1;
        }

        return 0;
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
        int numberOfUsers = users.getSize();
        int ladderWidth = ladder.getWidth();
        int numberOfPrizes = prizes.getSize();

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

    private void validatePositionWithinWidth(Line line, int position) {
        if (line.getSize() < position) {
            throw new IllegalArgumentException("[ERROR] 사용자의 위치가 사다리를 벗어났습니다.");
        }
    }
}
