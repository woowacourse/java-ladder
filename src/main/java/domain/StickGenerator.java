package domain;

public class StickGenerator {

    public Stick generate(int i) {
        if (i == 0) {
            return Stick.EMPTY;
        }
        if (i == 1) {
            return Stick.FILLED;
        }
        return null;
    }
}
