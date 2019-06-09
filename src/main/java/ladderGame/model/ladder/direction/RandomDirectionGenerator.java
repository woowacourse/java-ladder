package ladderGame.model.ladder.direction;

public class RandomDirectionGenerator implements DirectionGenerator {
    @Override
    public Direction generateDirection() {
        int randomNumber = (int) (Math.random() * 2);
        if (randomNumber % 2 == 0) {
            return Direction.STRAIGHT;
        }
        return Direction.RIGHT;
    }
}
