package domain;

enum Direction {

    LEFT, RIGHT, STAY;

    boolean isLeft() {
        return this.equals(LEFT);
    }

    boolean isRight() {
        return this.equals(RIGHT);
    }
}
