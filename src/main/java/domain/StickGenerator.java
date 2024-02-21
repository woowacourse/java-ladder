package domain;

class StickGenerator {
    
    public Stick generate(int i) {
        validateCommand(i);
        if (i == 0) {
            return Stick.EMPTY;
        }
        return Stick.FILLED;
    }

    private void validateCommand(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("0과 1이 아닌 값은 허용하지 않습니다.");
        }
    }
}
