package view;

import domain.ladder.common.Direction;

public class OutputView {

    public static final void printDirection(Direction direction) {
        if (direction.equals(Direction.RIGHT)) {
            System.out.print("|---");
        }
        if(direction.equals(Direction.LEFT)){
            System.out.print("---|      ");
        }
        if (direction.equals(Direction.DOWN)) {
            System.out.print("|      ");
        }
    }

}
