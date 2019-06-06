package ladderGame.model.ladder;

public class RandomBridgeGenerator {
    public Direction generateRandomDirection() {
        int randomNumber = (int) (Math.random() * 2);
        if (randomNumber % 2 == 0) {
            return Direction.STRAIGHT;
        }
        return Direction.RIGHT;
    }
}
