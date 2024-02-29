package ladder.domain.game;

import ladder.domain.resource.ladder.Ladder;
import ladder.domain.resource.prize.Prizes;
import ladder.domain.resource.user.Users;

public class LadderGame {

    private final GameResource gameResource;
    private final GameExecutor gameExecutor;
    private final GameResult gameResult;

    public LadderGame(GameResource gameResource,
                      GameExecutor gameExecutor,
                      GameResult gameResult
    ) {
        this.gameResource = gameResource;
        this.gameExecutor = gameExecutor;
        this.gameResult = gameResult;
    }

    public void registerResource(Users users, Prizes prizes, Ladder ladder) {
        gameResource.addUsers(users);
        gameResource.addPrizes(prizes);
        gameResource.addLadder(ladder);
    }

    public void startGame() {
        gameExecutor.validateGameEnvironment(gameResource);
        gameExecutor.execute(gameResource, gameResult);
    }

    public GameResource getGameResource() {
        return gameResource;
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
