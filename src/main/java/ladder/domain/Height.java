package ladder.domain;

class Height {

    private final int h;

    Height(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException();
        }
        h = height;
    }


    int getH() {
        return h;
    }

}
