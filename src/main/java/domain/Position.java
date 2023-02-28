package domain;


import java.util.List;

public class Position {

    private static final int RIGHT_DIFFERENCE = 0;
    private static final int LEFT_DIFFERENCE = -1;

    private int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int position) {
        return new Position(position);
    }

    public void move(int number) {
        if (checkConnection(number)) {
            changePosition(number);
        }
    }

    private void changePosition(int number) {
        if (position == number) {
            position++;
            return;
        }
        position--;
    }

    public int findConnectionNumber(List<Integer> numbers) {
        int connectionNumber = -1;

        for (int number : numbers) {
            connectionNumber = getConnectionNumber(connectionNumber, number);
        }

        return connectionNumber;
    }

    private int getConnectionNumber(int result, int number) {
        if (checkConnection(number)) {
            result = number;
        }

        return result;
    }

    private boolean checkConnection(int number) {
        return number - position == RIGHT_DIFFERENCE || number - position == LEFT_DIFFERENCE;
    }

    public int getPosition() {
        return position;
    }

}
