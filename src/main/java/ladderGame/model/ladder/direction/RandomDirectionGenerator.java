package ladderGame.model.ladder.direction;

public class RandomDirectionGenerator {
    public Direction generateRandomDirection() {
        int randomNumber = (int) (Math.random() * 2);
        if (randomNumber % 2 == 0) {
            return Direction.STRAIGHT;
        }
        return Direction.RIGHT;
    }
}
