package ladder.domain;

import ladder.domain.direction.Direction;
import ladder.domain.ladder.Ladder;
import ladder.domain.line.Line;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.domain.user.Users;

public class LadderGame {

    private static final int RIGHT_INDEX = 1;
    private static final int LEFT_INDEX = -1;
    private static final int STRAIGHT_INDEX = 0;

    private final GameResource gameResource;
    private final GameResult gameResult;

    public LadderGame(GameResource gameResource, GameResult gameResult) {
        this.gameResource = gameResource;
        this.gameResult = gameResult;
    }

    public void registerResource(Users users, Prizes prizes, Ladder ladder) {
        gameResource.add(users, prizes, ladder);
    }

    public void startGame() {
        validateGameEnvironment();
        executeLadderGame();
    }

    private void executeLadderGame() {
        Users users = gameResource.getUsers();
        Prizes prizes = gameResource.getPrizes();
        Ladder ladder = gameResource.getLadder();

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
            return RIGHT_INDEX;
        }

        if (direction == Direction.LEFT) {
            return LEFT_INDEX;
        }

        return STRAIGHT_INDEX;
    }

    private void validateGameEnvironment() {
        validateResourceNotNull();
        validateResourceConsistentSize();
    }

    private void validateResourceNotNull() {
        if (!gameResource.allFieldsNotNull()) {
            throw new IllegalArgumentException("[ERROR] 게임 리소스가 등록되지 않았습니다. 리소스를 먼저 등록해주세요.");
        }
    }

    private void validateResourceConsistentSize() {
        if (gameResource.allFieldConsistentSize()) {
            throw new IllegalArgumentException("[ERROR] 사용자 수, 당첨품 수, 사다리 너비는 모두 일치해야 합니다.");
        }
    }

    private void validatePositionWithinWidth(Line line, int position) {
        if (line.getSize() < position) {
            throw new IllegalArgumentException("[ERROR] 사용자의 위치가 사다리를 벗어났습니다.");
        }
    }

    public GameResource getGameResource() {
        return gameResource;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
