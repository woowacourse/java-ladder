package domain;

public class Floors {
    public Floors(int personCount, int floorCount) {
        if (floorCount < 1 || floorCount > 100) {
            throw new IllegalArgumentException();
        }
    }
}
