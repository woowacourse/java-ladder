package ladder.domain;

class Height {

    private final int height;

    Height(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 0보다 커야합니다");
        }
        this.height = height;
    }


    int getHeight() {
        return height;
    }

}
