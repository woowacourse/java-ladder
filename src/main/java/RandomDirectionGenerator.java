import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {
    @Override
    public Direction generate(){
        Random random = new Random();
        boolean flag = random.nextBoolean();
        if(flag){
            return Direction.DOWN;
        }
        return Direction.RIGHT;
    }
}
