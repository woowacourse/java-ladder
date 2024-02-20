public class LadderPiece {
    private final Direction direction;
    LadderPiece(Direction direction){
        this.direction = direction;
    }
    public Direction getDirection() {
        return direction;
    }
    public boolean isRightDirection(){
        return direction.equals(Direction.RIGHT);
    }
}
