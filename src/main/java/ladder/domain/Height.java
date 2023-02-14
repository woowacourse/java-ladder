package ladder.domain;

public class Height {

    public Height(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
