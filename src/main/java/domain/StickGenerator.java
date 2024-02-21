package domain;

class StickGenerator {

    public Stick generate(int i) {
        if (i == 0) {
            return Stick.EMPTY;
        }
        if (i == 1) {
            return Stick.FILLED;
        }
        throw new IllegalArgumentException("0과 1이 아닌 값은 허용하지 않습니다.");
    }
}
