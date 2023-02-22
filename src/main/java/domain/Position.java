package domain;


public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
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

    public boolean checkConnection(int number) {
        return number - position == 0 || number - position == -1;
    }

    public int getPosition() {
        return position;
    }
}
