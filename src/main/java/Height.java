public class Height {

    private final int height;

    public Height(String inputNumber){
        validate(inputNumber);
        this.height = Integer.parseInt(inputNumber);
    }

    private void validate(String inputNumber){
        validateIsNumeric(inputNumber);
    }

    private void validateIsNumeric(String tryNumber) {
        if (!tryNumber.matches("\\d+")) {
            throw new IllegalArgumentException("높이는 숫자만 입력 가능합니다.");
        }
    }
    public int getHeight() {
        return height;
    }
}
