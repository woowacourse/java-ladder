package domain;

public class Floor {
    public Floor(int personCount) {
        if (personCount < 2 || personCount > 100) {
            throw new IllegalArgumentException();
        }
    }
}
